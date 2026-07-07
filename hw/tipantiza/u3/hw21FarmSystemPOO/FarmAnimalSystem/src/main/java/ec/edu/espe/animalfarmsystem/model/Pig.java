
package ec.edu.espe.animalfarmsystem.model;

import ec.edu.espe.animalfarmsystem.controller.IMeatAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Alexander Tipantiza, The Softwariors, @ESPE
 */
public class Pig extends FarmAnimal implements IMeatAnimal{
    private float idealWeight;
    private boolean reachedIdealWeight;

    public Pig(float idealWeight, boolean reachedIdealWeight, float weight, String breed, Date bornOn, int id, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cuts) {
        super(id, breed, bornOn, weight, slaughterHouse, product, cuts);
        this.idealWeight = idealWeight;
        this.reachedIdealWeight = reachedIdealWeight;
    }

    
    
    @Override
    public void feed(Food food) {
        System.err.println("Feeding THE PIG with foof --> " + food + " in a bowl and water");
        System.out.println("Feeding the PIG with " + food.getDescription());
        float newWeight = this.getWeight() + 2.5f;
        this.setWeight(newWeight);
        
        if (newWeight >= idealWeight) {
            reachedIdealWeight = true;
            System.out.println("Pig " + this.getId() + " has reached ideal weight: " + newWeight + " kg");
        } else {
            System.out.println("Current weight: " + newWeight + " kg (Ideal: " + idealWeight + " kg)");
        }
    }
    
     @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts;
        cuts = new ArrayList<>();
        return cuts;
    }
    
    @Override
    public boolean isReadyForSlaughter() {
        return reachedIdealWeight;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        if (isReadyForSlaughter()) {
            this.slaughterHouse = slaughterHouse;
            System.out.println("PIG " + this.getId() + " SENT TO SLAUGHTERHOUSE");
            System.out.println("SlaughterHouse: " + slaughterHouse.getName());
            System.out.println("Address: " + slaughterHouse.getAddress());
            System.out.println("Weight: " + this.getWeight() + " kg");
            
            showPorkCuts();
            
        } else {
            System.out.println("Pig " + this.getId() + " is NOT ready for slaughter yet");
            System.out.println("Current weight: " + this.getWeight() + " kg");
            System.out.println("Ideal weight: " + idealWeight + " kg");
        } 
    }
    
    private void showPorkCuts() {
        System.out.println("\nCUTS PERFORMED ON PIG " + this.getId() + ":");
        System.out.println("Jamón (Piernas traseras)");
        System.out.println("Paleta (Pierna delantera)");
        System.out.println("Costillar");
        System.out.println("Lomo de cerdo");
        System.out.println("All cuts have been completed successfully");
    }
    
    /**
     * @return the idealWeight
     */
    public float getIdealWeight() {
        return idealWeight;
    }

    /**
     * @param idealWeight the idealWeight to set
     */
    public void setIdealWeight(float idealWeight) {
        this.idealWeight = idealWeight;
    }

    /**
     * @return the reachedIdealWeight
     */
    public boolean isReachedIdealWeight() {
        return reachedIdealWeight;
    }

    /**
     * @param reachedIdealWeight the reachedIdealWeight to set
     */
    public void setReachedIdealWeight(boolean reachedIdealWeight) {
        this.reachedIdealWeight = reachedIdealWeight;
    }

    
    
    
}
