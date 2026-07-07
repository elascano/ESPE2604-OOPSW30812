package ec.edu.espe.farmsystem.model;

import ec.edu.espe.farmsystem.controller.IMeatAnimal;
import ec.edu.espe.farmsystem.controller.IProduceAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Joel Sanchez, The_Softwarriors ,@ESPE
 */

public class Chicken extends FarmAnimal implements IMeatAnimal, IProduceAnimal {
    private boolean isMolting;
    private int numberOfEggsPerWeek;
    
    public void layAnEgg() {
        if (!isMolting) {
            System.out.println("The chicken laid an egg!");
            numberOfEggsPerWeek++;
        } else {
            System.out.println("The chicken is molting and cannot lay eggs.");
        }
    }

    public Chicken(boolean isMolting, int numberOfEggsPerWeek, int id, String breed, Date bornOn, float weight, 
                   SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cuts) {
        super(id, breed, bornOn, weight, slaughterHouse, product, cuts);
        this.isMolting = isMolting;
        this.numberOfEggsPerWeek = numberOfEggsPerWeek;
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding Chicken with: " + food.getDescription());
        this.setWeight(this.getWeight() + 0.1f);
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts = new ArrayList<>();
        System.out.println("=== CHICKEN CUTS ===");
        cuts.add(new Cut(1, "Breast", "Cut from the chest", 0.5f));
        cuts.add(new Cut(2, "Thigh", "Cut from the leg", 0.3f));
        cuts.add(new Cut(3, "Wing", "Cut from the wing", 0.2f));
        cuts.add(new Cut(4, "Drumstick", "Cut from the lower leg", 0.25f));
        this.setCuts(cuts);
        return cuts;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        System.out.println("Sending CHICKEN to slaughterhouse: " + slaughterHouse.getName());
        this.slaughterHouse = slaughterHouse;
    }

    @Override
    public Product produce() {
        Product eggs = new Product(201, "Chicken Eggs", "Units", numberOfEggsPerWeek);
        this.setProduct(eggs);
        System.out.println("Eggs produced: " + numberOfEggsPerWeek + " units");
        return eggs;
    }

    @Override
    public void measureQuantity(String unit, float quantity) {
        System.out.println("Measuring: " + quantity + " " + unit);
        if (this.getProduct() != null) {
            this.getProduct().setUnit(unit);
            this.getProduct().setQuantity(quantity);
        }
    }

    public boolean isIsMolting() {
        return isMolting;
    }

    public void setIsMolting(boolean isMolting) {
        this.isMolting = isMolting;
    }

    public int getNumberOfEggsPerWeek() {
        return numberOfEggsPerWeek;
    }

    public void setNumberOfEggsPerWeek(int numberOfEggsPerWeek) {
        this.numberOfEggsPerWeek = numberOfEggsPerWeek;
    }
}