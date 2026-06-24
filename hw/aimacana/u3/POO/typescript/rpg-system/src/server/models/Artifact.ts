import { Item } from './Item';
import type { IEquippable, ISellable } from './interfaces';
import type { Character } from './Character';
import { ArtifactSlot } from './enums';
import { InventoryFullException } from './exceptions';

export class Artifact extends Item implements IEquippable, ISellable {
  private bonusHealth: number;
  private slot: ArtifactSlot;

  constructor(id: string, name: string, weight: number, description: string, baseValue: number, bonusHealth: number, slot: ArtifactSlot) {
    super(id, name, weight, description, baseValue);
    this.bonusHealth = bonusHealth;
    this.slot = slot;
  }

  public getBonusHealth(): number { return this.bonusHealth; }
  public getSlot(): ArtifactSlot { return this.slot; }

  public equip(target: Character): void {
    const currentlyEquipped = target.getEquippedArtifact(this.slot);
    target.removeItem(this); // Quitar de mochila
    if (currentlyEquipped) {
      currentlyEquipped.unequip(target); // Devolver el viejo a mochila
    }
    target.setMaxHp(target.getMaxHp() + this.bonusHealth);
    target.heal(this.bonusHealth); // Cura el extra añadido
    target.setEquippedArtifact(this.slot, this);
  }

  public unequip(target: Character): void {
    target.setMaxHp(target.getMaxHp() - this.bonusHealth);
    if (target.getHp() > target.getMaxHp()) {
      // Ajustar HP actual si se pasa del nuevo máximo
      target.takeDamage(target.getHp() - target.getMaxHp());
    }
    target.setEquippedArtifact(this.slot, undefined);
    try {
      target.addItem(this); // Devolver a mochila
    } catch (e) {
      if (e instanceof InventoryFullException) {
        // Ignorar
      }
    }
  }

  public calculateSaleValue(): number {
    return this.getBaseValue() * 1.5; // Los artefactos son valiosos
  }
}
