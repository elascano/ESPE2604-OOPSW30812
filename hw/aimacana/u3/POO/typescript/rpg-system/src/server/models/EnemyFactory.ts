import { Character } from './Character';
import { Warrior } from './Warrior';
import { Mage } from './Mage';

/**
 * Patrón Factory Method.
 * Centraliza la creación de enemigos en TypeScript.
 */
export class EnemyFactory {
  public static spawnEnemyForLevel(level: number): Character {
    const id = `enemy_${Math.random().toString(36).substring(2, 9)}`;
    const hp = 100 + (level * 50);
    const damage = 5 + (level * 2);
    
    const roll = Math.random();
    if (roll < 0.33) {
      return new Warrior(id, "Troll de las Montañas", level, hp, damage);
    } else if (roll < 0.66) {
      return new Warrior(id, "Orco Furioso", level, hp * 1.2, damage * 1.5);
    } else {
      return new Mage(id, "Brujo Oscuro", level, hp * 0.8, damage * 2.0, 100.0);
    }
  }
}
