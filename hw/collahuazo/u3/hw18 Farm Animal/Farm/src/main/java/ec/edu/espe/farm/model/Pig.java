package ec.edu.espe.farm.model;

import ec.edu.espe.farm.contracts.IMeatAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Collahuazo Brandon, CodeBros, @ESPE
 */
public class Pig extends FarmAnimal implements IMeatAnimal {

    private float idealWeight;

 
    public Pig() {
        super();
    }

  
    public Pig(int id, String breed, Date bornOn, float weight, Health health, float idealWeight) {
    
        super(id, breed, bornOn, weight, health);
        this.idealWeight = idealWeight;
    }

    
    @Override
    public ArrayList<Cut> cut() {
        
        return new ArrayList<>();
    }

    @Override
    public boolean sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
      
        return false;
    }

   
    public float getIdealWeight() {
        return idealWeight;
    }

    public void setIdealWeight(float idealWeight) {
        this.idealWeight = idealWeight;
    }

    @Override
    public String toString() {
        return "Pig | ID: " + getId() + " | Breed: " + getBreed() + " | Weight: " + getWeight() + "kg";
    }
}
