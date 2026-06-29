import { CharacterRepository } from '../repositories/CharacterRepository';
import { Character } from '../models/Character';
import { Item } from '../models/Item';
import { Weapon } from '../models/Weapon';
import { ArmorSlot, ArtifactSlot } from '../models/enums';
import { CharacterDeadException } from '../models/exceptions';
import { CharacterFactory } from '../models/CharacterFactory';
import { ItemFactory } from '../models/ItemFactory';

// Para simplificar la validación de interfaces en TS ya que usa duck typing y no implements nominal en runtime
function isIEquippable(item: any): boolean {
  return typeof item.equip === 'function' && typeof item.unequip === 'function';
}

function isIConsumable(item: any): boolean {
  return typeof item.consume === 'function';
}

export class GameService {
  private repository: CharacterRepository;
  private currentCharacter: Character | null = null;

  constructor(repository: CharacterRepository) {
    this.repository = repository;
  }

  public createNewCharacter(character: Character): string {
    this.currentCharacter = character;
    return `Nuevo personaje creado en memoria: ${character.getName()}`;
  }

  public createCharacter(name: string, classType: string): string {
    const id = Math.random().toString(36).substring(2, 9);
    try {
      const char = CharacterFactory.createCharacter(classType, id, name);
      this.currentCharacter = char;
      return `Nuevo personaje (${classType}) creado en memoria: ${name}`;
    } catch (e: any) {
      return `Error al crear personaje: ${e.message}`;
    }
  }

  public restCharacter(): string {
    if (!this.currentCharacter) {
      return 'Error: No hay personaje activo para descansar.';
    }
    this.currentCharacter.heal(this.currentCharacter.getMaxHp());
    return `${this.currentCharacter.getName()} ha descansado. HP restaurado al máximo.`;
  }

  public lootRandomItem(): string {
    if (!this.currentCharacter) {
      return 'Error: No hay personaje activo para buscar botín.';
    }
    try {
      const item = ItemFactory.createRandomLoot(this.currentCharacter.getLevel());
      this.currentCharacter.addItem(item);
      return `Has encontrado un ítem: ${item.getName()}`;
    } catch (e: any) {
      return `Error: ${e.message}`;
    }
  }

  public unequipWeapon(): string {
    if (!this.currentCharacter) return 'No hay personaje activo.';
    const weapon = this.currentCharacter.getEquippedWeapon();
    if (weapon) {
      weapon.unequip(this.currentCharacter);
      return `${this.currentCharacter.getName()} se ha quitado: ${weapon.getName()}`;
    }
    return 'No hay arma equipada.';
  }

  public async loadCharacter(characterId: string): Promise<string> {
    const loaded = await this.repository.findById(characterId);
    if (!loaded) {
      return 'Error: Personaje no encontrado en la base de datos.';
    }
    this.currentCharacter = loaded;
    return `Partida cargada exitosamente desde MongoDB: ${this.currentCharacter.getName()}`;
  }

  public async saveGame(): Promise<string> {
    if (!this.currentCharacter) {
      return 'No hay ningún personaje activo para guardar.';
    }
    if (this.currentCharacter.getHp() <= 0) {
      return 'No puedes guardar una partida de un personaje muerto.';
    }
    await this.repository.save(this.currentCharacter);
    return 'Partida guardada correctamente en MongoDB.';
  }

  public async getAllSavedCharacters(): Promise<Character[]> {
    return await this.repository.findAll();
  }

  public interactWithItem(item: Item): string {
    if (!this.currentCharacter) {
      return 'No hay personaje seleccionado.';
    }
    if (this.currentCharacter.getHp() <= 0) {
      return 'Estás muerto. No puedes usar objetos.';
    }

    if (isIEquippable(item)) {
      (item as any).equip(this.currentCharacter);
      return `${this.currentCharacter.getName()} ha equipado: ${item.getName()}. Estadísticas actualizadas.`;
    }

    if (isIConsumable(item)) {
      (item as any).consume(this.currentCharacter);
      this.currentCharacter.removeItem(item);
      return `${this.currentCharacter.getName()} ha consumido: ${item.getName()}`;
    }

    return 'Este ítem no se puede usar.';
  }

  public interactWithItemById(itemId: string): string {
    const c = this.getCurrentCharacter();
    if (!c) return 'No hay personaje activo.';
    for (const item of c.getInventory()) {
      if (item.getId() === itemId) {
        return this.interactWithItem(item);
      }
    }
    return 'El ítem no está en el inventario.';
  }

  public unequipArmor(slot: ArmorSlot): string {
    const c = this.getCurrentCharacter();
    if (!c) return 'No hay personaje activo.';
    const armor = c.getEquippedArmor(slot);
    if (armor) {
      armor.unequip(c);
      return `${c.getName()} se ha quitado: ${armor.getName()}`;
    }
    return 'No hay nada equipado en esa ranura.';
  }

  public unequipArtifact(slot: ArtifactSlot): string {
    const c = this.getCurrentCharacter();
    if (!c) return 'No hay personaje activo.';
    const art = c.getEquippedArtifact(slot);
    if (art) {
      art.unequip(c);
      return `${c.getName()} se ha quitado: ${art.getName()}`;
    }
    return 'No hay nada equipado en esa ranura.';
  }

  public attackTarget(target: Character): string {
    if (!this.currentCharacter) {
      return 'No hay personaje seleccionado para atacar.';
    }
    if (this.currentCharacter.getHp() <= 0) {
      return '¡Estás muerto! Carga otra partida.';
    }

    const oldEnemyHp = target.getHp();
    let result = '';
    try {
      this.currentCharacter.attack(target);
      const damageDealt = oldEnemyHp - target.getHp();
      result = `${this.currentCharacter.getName()} atacó por ${damageDealt.toFixed(1)} de daño.\n`;

      // Counter Attack
      if (target.getHp() > 0) {
        const oldPlayerHp = this.currentCharacter.getHp();
        target.attack(this.currentCharacter);
        const damageTaken = oldPlayerHp - this.currentCharacter.getHp();
        result += `El enemigo contraatacó causando ${damageTaken.toFixed(1)} de daño.\n`;

        if (this.currentCharacter.getHp() <= 0) {
          result += '¡GAME OVER! Has sido derrotado en combate.';
        }
      } else {
        result += '¡Enemigo derrotado!\n';
        if (this.currentCharacter.gainExp(50)) {
          result += `⭐ ¡SUBISTE DE NIVEL! Ahora eres Nivel ${this.currentCharacter.getLevel()}. (Vida Restaurada)`;
        } else {
          result += `✨ Has ganado 50 Puntos de Experiencia (${this.currentCharacter.getExp()}/100).`;
        }
      }
    } catch (e) {
      if (e instanceof CharacterDeadException) {
        return '❌ ' + e.message;
      }
      throw e;
    }

    return result;
  }

  public getCurrentCharacter(): Character | null {
    return this.currentCharacter;
  }
}
