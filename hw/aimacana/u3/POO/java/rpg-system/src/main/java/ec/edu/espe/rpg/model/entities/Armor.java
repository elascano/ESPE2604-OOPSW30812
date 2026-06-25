package ec.edu.espe.rpg.model.entities;

import ec.edu.espe.rpg.model.interfaces.IEquippable;
import ec.edu.espe.rpg.model.interfaces.ISellable;
import ec.edu.espe.rpg.model.enums.ArmorSlot;

public class Armor extends Item implements IEquippable, ISellable {
    private double defense;
    private ArmorSlot slot;

    public Armor(String id, String name, double weight, String description, double baseValue, double defense, ArmorSlot slot) {
        super(id, name, weight, description, baseValue);
        this.defense = defense;
        this.slot = slot;
    }

    public double getDefense() { return defense; }
    public ArmorSlot getSlot() { return slot; }

    @Override
    public void equip(Character target) {
        Armor currentlyEquipped = target.getEquippedArmor(slot);
        target.removeItem(this); // Quitar de mochila
        if (currentlyEquipped != null) {
            currentlyEquipped.unequip(target); // Devolver el viejo a mochila
        }
        target.setBonusDefense(target.getBonusDefense() + defense);
        target.setEquippedArmor(slot, this);
    }

    @Override
    public void unequip(Character target) {
        target.setBonusDefense(target.getBonusDefense() - defense);
        target.setEquippedArmor(slot, null);
        try {
            target.addItem(this); // Devolver a mochila
        } catch (ec.edu.espe.rpg.model.exceptions.InventoryFullException e) {}
    }

    @Override
    public double calculateSaleValue() {
        return getBaseValue();
    }
}
