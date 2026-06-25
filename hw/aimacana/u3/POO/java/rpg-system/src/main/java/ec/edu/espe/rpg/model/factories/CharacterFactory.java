package ec.edu.espe.rpg.model.factories;

import ec.edu.espe.rpg.model.entities.Character;
import ec.edu.espe.rpg.model.entities.Warrior;
import ec.edu.espe.rpg.model.entities.Mage;

/**
 * Patrón Factory Method.
 * Centraliza la creación de personajes jugadores, encapsulando sus atributos iniciales.
 */
public class CharacterFactory {

    public static Character createCharacter(String type, String id, String name) {
        if ("Warrior".equalsIgnoreCase(type)) {
            return new Warrior(id, name, 1, 100.0, 15.0);
        } else if ("Mage".equalsIgnoreCase(type)) {
            return new Mage(id, name, 1, 80.0, 20.0, 50.0);
        }
        throw new IllegalArgumentException("Unknown character type: " + type);
    }
}
