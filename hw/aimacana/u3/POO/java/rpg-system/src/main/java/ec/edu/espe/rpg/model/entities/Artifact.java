package ec.edu.espe.rpg.model.entities;

import ec.edu.espe.rpg.model.interfaces.IEquippable;
import ec.edu.espe.rpg.model.interfaces.ISellable;
import ec.edu.espe.rpg.model.enums.ArtifactSlot;

public class Artifact extends Item implements IEquippable, ISellable {
    private double bonusHealth;
    private ArtifactSlot slot;

    public Artifact(String id, String name, double weight, String description, double baseValue, double bonusHealth, ArtifactSlot slot) {
        super(id, name, weight, description, baseValue);
        this.bonusHealth = bonusHealth;
        this.slot = slot;
    }

    public double getBonusHealth() { return bonusHealth; }
    public ArtifactSlot getSlot() { return slot; }

    @Override
    public void equip(Character target) {
        Artifact currentlyEquipped = target.getEquippedArtifact(slot);
        target.removeItem(this); // Quitar de mochila
        if (currentlyEquipped != null) {
            currentlyEquipped.unequip(target); // Devolver el viejo a mochila
        }
        target.setMaxHp(target.getMaxHp() + bonusHealth);
        target.heal(bonusHealth); // Cura el extra añadido
        target.setEquippedArtifact(slot, this);
    }

    @Override
    public void unequip(Character target) {
        target.setMaxHp(target.getMaxHp() - bonusHealth);
        if (target.getHp() > target.getMaxHp()) {
            // Ajustar HP actual si se pasa del nuevo máximo
            target.takeDamage(target.getHp() - target.getMaxHp()); 
        }
        target.setEquippedArtifact(slot, null);
        try {
            target.addItem(this); // Devolver a mochila
        } catch (ec.edu.espe.rpg.model.exceptions.InventoryFullException e) {}
    }

    @Override
    public double calculateSaleValue() {
        return getBaseValue() * 1.5; // Los artefactos son valiosos
    }
}
