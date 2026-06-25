package ec.edu.espe.rpg.model.entities;

import ec.edu.espe.rpg.model.interfaces.IConsumable;
import ec.edu.espe.rpg.model.interfaces.ISellable;

public class Potion extends Item implements IConsumable, ISellable {
    private double restorationAmount;

    public Potion(String id, String name, double weight, String description, double baseValue, double restorationAmount) {
        super(id, name, weight, description, baseValue);
        this.restorationAmount = restorationAmount;
    }

    public double getRestorationAmount() { return restorationAmount; }

    @Override
    public void consume(Character target) {
        System.out.println(target.getName() + " consumes " + getName());
        target.heal(restorationAmount);
    }

    @Override
    public double calculateSaleValue() {
        // Potions maintain their value unless consumed
        return getBaseValue();
    }
}
