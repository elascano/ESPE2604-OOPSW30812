/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.farmsystem.model;

import ec.edu.espe.farmsystem.controller.IMeatAnimal;
import ec.edu.espe.farmsystem.controller.IProduceAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class Cow extends FarmAnimal implements IMeatAnimal, IProduceAnimal{
    private boolean producingMilk ;
    
    public float milk() {
        if (isProducingMilk()) {
            System.out.println("Producing milk...");
            float milkProduced = 15.5f; 
            System.out.println("The cow produced " + milkProduced + " liters of milk");
            return milkProduced;
        } else {
            System.out.println("This cow is not producing milk");
            return 0;
        }
    }
    
    public boolean isProducingMilk() {
        return producingMilk;
    }

    public Cow(boolean producingMilk, int id, String breed, Date bornOn, float weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cuts) {
        super(id, breed, bornOn, weight, slaughterHouse, product, cuts);
        this.producingMilk = producingMilk;
    }
    
    
    @Override
    public void feed(Food food) {
        System.out.println("Feeding THE COW with food -->"  + food + "in a bowl and water");
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts = new ArrayList<>();
        System.out.println("");

        cuts.add(new Cut(1, "T-Bone Steak", "Cut from the short loin", 2.5f));
        cuts.add(new Cut(2, "Ribeye", "Cut from the rib section", 3.0f));
        cuts.add(new Cut(3, "Sirloin", "Cut from the rear back", 4.0f));
        cuts.add(new Cut(4, "Cattle prod", "Cut from the hind leg", 5.0f));

        this.setCuts(cuts);
        return cuts;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaugtherHouse) {
        this.slaughterHouse = slaugtherHouse;
    }

    @Override
    public Product produce() {
        if (isProducingMilk()) {
            Product milk = new Product(101, "Cow Milk", "Liters", this.milk());
            this.setProduct(milk);
            return milk;
        } else {
            System.out.println("This cow is not producing milk.");
            return null;
        }
    }

    @Override
    public void measureQuantity(String unit, float quantity) {
        System.out.println("Measuring: " + quantity + " " + unit);
        this.getProduct().setUnit(unit);
        this.getProduct().setQuantity(quantity);
    }

    /**
     * @param producingMilk the producingMilk to set
     */
    public void setProducingMilk(boolean producingMilk) {
        this.producingMilk = producingMilk;
    }

    
   

    
    
}
