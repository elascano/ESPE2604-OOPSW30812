package ec.edu.espe.farm.model;

import java.util.Date;

/**
 * @author Collahuazo Brandon, CodeBros, @ESPE
 */
public class Sheep extends FarmAnimal {

    private Date lastSheering;

    public Sheep() {
        super();
    }

    public Sheep(int id, String breed, Date bornOn, float weight, Health health, Date lastSheering) {
        super(id, breed, bornOn, weight, health);
        this.lastSheering = lastSheering;
    }

  
    public boolean sheer() {
       
        return false;
    }


    public Date getLastSheering() {
        return lastSheering;
    }

    public void setLastSheering(Date lastSheering) {
        this.lastSheering = lastSheering;
    }

    @Override
    public String toString() {
        return "Sheep | ID: " + getId() + " | Breed: " + getBreed() + " | Weight: " + getWeight() + "kg";
    }
}
