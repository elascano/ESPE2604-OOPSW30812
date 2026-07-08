
package ec.edu.espe.animalfarmsystem.model;

import ec.edu.espe.animalfarmsystem.controller.IMeatAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
public class Cow extends FarmAnimal implements IMeatAnimal{
    private float milkProduction;
    private boolean canProduceMilk;
    private static final float MIN_MILK_PRODUCTION = 5.0f;

    public Cow(int id, boolean canProduceMilk, String breed, Date bornOn, float weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cuts, float milkProduction) {
        super(id, breed, bornOn, weight, slaughterHouse, product, cuts);
        this.milkProduction = milkProduction;
        this.canProduceMilk = milkProduction >= MIN_MILK_PRODUCTION;
    }

    
    @Override
    public void feed(Food food) {
        System.out.println("Feeding the COW with " + food.getDescription());
        if (canProduceMilk) {
            milkProduction = milkProduction - 0.3f;
            if (milkProduction < MIN_MILK_PRODUCTION) {
                canProduceMilk = false;
                System.out.println("Cow " + this.getId() + " can NO LONGER produce milk!");
                System.out.println("Current production: " + milkProduction + " L/day");
                System.out.println("Minimum required: " + MIN_MILK_PRODUCTION + " L/day");
            } else {
                System.out.println("Milk production: " + milkProduction + " L/day");
            }
        }
    }

    @Override
    public ArrayList<Cut> cut() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        if (isReadyForSlaughter()) {
            this.slaughterHouse = slaughterHouse;
            System.out.println("COW " + this.getId() + " SENT TO SLAUGHTERHOUSE");
            System.out.println("SlaughterHouse: " + slaughterHouse.getName());
            System.out.println("Address: " + slaughterHouse.getAddress());
            System.out.println("Reason: No longer produces milk");
            System.out.println("Final milk production: " + milkProduction + " L/day");
            System.out.println("Weight: " + this.getWeight() + " kg");
            
            showBeefCuts();
            
        } else {
            System.out.println("Cow " + this.getId() + " is NOT ready for slaughter yet");
            System.out.println("Milk production: " + milkProduction + " L/day");
            System.out.println("Can produce milk: " + (canProduceMilk ? "YES" : "NO"));
        }
    }
    
    private void showBeefCuts() {
        System.out.println("\nUTS PERFORMED ON COW " + this.getId() + ":");
        System.out.println("Lomo Fino");
        System.out.println("Picaña");
        System.out.println("Costilla de res");
        System.out.println("Pulpa negra (bistecs)");
        System.out.println("Pulpa blanca (bistecs)");
        System.out.println("All cuts have been completed successfully");
    }
    
    @Override
    public boolean isReadyForSlaughter() {
        return !canProduceMilk;
    }

    /**
     * @return the milkProduction
     */
    public float getMilkProduction() {
        return milkProduction;
    }

    /**
     * @param milkProduction the milkProduction to set
     */
    public void setMilkProduction(float milkProduction) {
        this.milkProduction = milkProduction;
        this.canProduceMilk = milkProduction >= MIN_MILK_PRODUCTION;
    }

    /**
     * @return the canProduceMilk
     */
    public boolean isCanProduceMilk() {
        return canProduceMilk;
    }

    /**
     * @param canProduceMilk the canProduceMilk to set
     */
    public void setCanProduceMilk(boolean canProduceMilk) {
        this.canProduceMilk = canProduceMilk;
    }

    /**
     * @return the MIN_MILK_PRODUCTION
     */
    public static float getMIN_MILK_PRODUCTION() {
        return MIN_MILK_PRODUCTION;
    }

    
    
}
