package ec.edu.espe.rpg.model.interfaces;

import ec.edu.espe.rpg.model.entities.Character;

public interface IEquippable {
    void equip(Character target);
    void unequip(Character target);
}
