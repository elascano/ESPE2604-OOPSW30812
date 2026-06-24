package ec.edu.espe.rpg.model.entities;

import ec.edu.espe.rpg.model.interfaces.IEquippable;
import ec.edu.espe.rpg.model.interfaces.IRepairable;
import ec.edu.espe.rpg.model.interfaces.ISellable;

public class Weapon extends Item implements IEquippable, IRepairable, ISellable {
    private double baseDamage;
    private double attackSpeed;
    private double durability;

    public Weapon(String id, String name, double weight, String description, double baseValue, double baseDamage, double attackSpeed) {
        super(id, name, weight, description, baseValue);
        this.baseDamage = baseDamage;
        this.attackSpeed = attackSpeed;
        this.durability = 100.0;
    }

    public double getBaseDamage() { return baseDamage; }
    public double getAttackSpeed() { return attackSpeed; }

    @Override
    public void equip(Character target) {
        target.setBonusDamage(target.getBonusDamage() + baseDamage);
    }

    @Override
    public void unequip(Character target) {
        target.setBonusDamage(target.getBonusDamage() - baseDamage);
    }

    @Override
    public void repair(double amount) {
        this.durability += amount;
        if (this.durability > 100.0) this.durability = 100.0;
    }

    @Override
    public double getDurability() {
        return durability;
    }

    @Override
    public double calculateSaleValue() {
        return getBaseValue() * (durability / 100.0);
    }
}
