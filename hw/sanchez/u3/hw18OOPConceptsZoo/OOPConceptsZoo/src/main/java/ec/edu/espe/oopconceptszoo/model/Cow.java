/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oopconceptszoo.model;

import ec.edu.espe.oopconceptszoo.controller.IMeatAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Joel Sanchez, The Softwarriors, @ESPE
 *
 */
public class Cow extends FarmAnimal implements IMeatAnimal {
    private boolean isProducingMilk;
    private float milkProduced;
    
    public Cow(int id, String breed, Date bornOn, float weight, boolean isProducingMilk) {
        super(id, breed, bornOn, weight);
        this.isProducingMilk = isProducingMilk;
        this.milkProduced = 0;
    }
    
    public boolean isProducingMilk() {
        return isProducingMilk;
    }
    
    public void setProducingMilk(boolean producingMilk) {
        isProducingMilk = producingMilk;
    }
    
    public float milk() {
        if (isProducingMilk) {
            milkProduced = 10 + (float) (Math.random() * 20);
            return milkProduced;
        } else {
            return 0;
        }
    }
    
    public float getMilkProduced() {
        return milkProduced;
    }
    
    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts = new ArrayList<>();
        cuts.add(new Cut(1, "Sirloin", "Sirloin cut", 5.0f));
        cuts.add(new Cut(2, "Rib", "Rib cut", 3.5f));
        cuts.add(new Cut(3, "Brisket", "Brisket cut", 4.0f));
        return cuts;
    }
    
    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        System.out.println("Sending cow to slaughter house: " + slaughterHouse);
    }
    
    @Override
    public void food(Food food) {
        System.out.println("Feeding cow with: " + food.getDescription());
    }
    
    @Override
    public String toString() {
        return "Cow{" +
                "isProducingMilk=" + isProducingMilk +
                ", milkProduced=" + milkProduced +
                ", " + super.toString() +
                '}';
    }
}