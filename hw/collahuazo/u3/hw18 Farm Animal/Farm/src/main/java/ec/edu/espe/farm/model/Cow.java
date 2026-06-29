package ec.edu.espe.farm.model;

import ec.edu.espe.farm.contracts.IMeatAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Collahuazo Brandon, CodeBros, @ESPE
 */
public class Cow extends FarmAnimal implements IMeatAnimal {

    private boolean isProducingMilk;
    private float milkPerHour;

 
    public Cow() {
        super();
    }

    public Cow(int id, String breed, Date bornOn, float weight, Health health, boolean isProducingMilk, float milkPerHour) {
    
        super(id, breed, bornOn, weight, health);
        this.isProducingMilk = isProducingMilk;
        this.milkPerHour = milkPerHour;
    }

   
    @Override
    public ArrayList<Cut> cut() {
     
        return new ArrayList<>();
    }

    @Override
    public boolean sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
       
        return false;
    }

    public Float milk() {
   
        return 0.0f;
    }

 
    public boolean isProducingMilk() {
        return this.isProducingMilk;
    }

    public void setIsProducingMilk(boolean isProducingMilk) {
        this.isProducingMilk = isProducingMilk;
    }

    public float getMilkPerHour() {
        return milkPerHour;
    }

    public void setMilkPerHour(float milkPerHour) {
        this.milkPerHour = milkPerHour;
    }

    @Override
    public String toString() {
        return "Cow | ID: " + getId() + " | Breed: " + getBreed() + " | Weight: " + getWeight() + "kg";
    }
}
