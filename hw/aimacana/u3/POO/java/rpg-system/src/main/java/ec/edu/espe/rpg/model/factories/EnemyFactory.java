package ec.edu.espe.rpg.model.factories;

import ec.edu.espe.rpg.model.entities.Character;
import ec.edu.espe.rpg.model.entities.Warrior;
import ec.edu.espe.rpg.model.entities.Mage;
import java.util.UUID;

/**
 * Patrón Factory Method.
 * Centraliza la creación de enemigos, escalándolos por nivel.
 */
public class EnemyFactory {

    public static Character spawnEnemyForLevel(int level) {
        String id = "enemy_" + UUID.randomUUID().toString();
        double hp = 100 + (level * 50);
        double damage = 5 + (level * 2);
        
        double roll = Math.random();
        if (roll < 0.33) {
            return new Warrior(id, "Troll de las Montañas", level, hp, damage);
        } else if (roll < 0.66) {
            return new Warrior(id, "Orco Furioso", level, hp * 1.2, damage * 1.5);
        } else {
            return new Mage(id, "Brujo Oscuro", level, hp * 0.8, damage * 2.0, 100.0);
        }
    }
}
