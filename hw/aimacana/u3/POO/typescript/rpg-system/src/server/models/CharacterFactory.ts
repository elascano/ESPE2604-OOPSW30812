import { Character } from './Character';
import { Warrior } from './Warrior';
import { Mage } from './Mage';

/**
 * Patrón Factory Method.
 * Centraliza la creación de personajes jugadores, encapsulando sus atributos iniciales.
 */
export class CharacterFactory {
  public static createCharacter(type: string, id: string, name: string): Character {
    if (type.toLowerCase() === 'warrior') {
      return new Warrior(id, name, 1, 100.0, 15.0);
    } else if (type.toLowerCase() === 'mage') {
      return new Mage(id, name, 1, 80.0, 20.0, 50.0);
    }
    throw new Error(`Unknown character type: ${type}`);
  }
}
