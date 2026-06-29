package ec.edu.espe.farm.model;

import java.util.Date;

/**
 * @author Collahuazo Brandon, CodeBros, @ESPE
 */
public class Chicken extends FarmAnimal {

    private boolean isMolting;
    private int numberOfEggsPerWeek;

    public Chicken() {
        super();
    }

    public Chicken(int id, String breed, Date bornOn, float weight, Health health, boolean isMolting, int numberOfEggsPerWeek) {
        super(id, breed, bornOn, weight, health);
        this.isMolting = isMolting;
        this.numberOfEggsPerWeek = numberOfEggsPerWeek;
    }

  
    public void layAnEgg() {
      
    }

    public void updateEggProduction() {
     
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

    @Override
    public String toString() {
        return "Chicken | ID: " + getId() + " | Breed: " + getBreed() + " | Weight: " + getWeight() + "kg";
    }
}
