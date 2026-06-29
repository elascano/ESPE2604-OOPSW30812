package ec.edu.espe.oopconceptszoo.model;

import java.util.Date;

/**
 * @author Joel Sanchez, The Softwarriors, @ESPE
 *
 */
public class Sheep extends FarmAnimal {
    private Date lastSheering;
    
    public Sheep(int id, String breed, Date bornOn, float weight, Date lastSheering) {
        super(id, breed, bornOn, weight);
        this.lastSheering = lastSheering;
    }
    
    public Date getLastSheering() {
        return lastSheering;
    }
    
    public void setLastSheering(Date lastSheering) {
        this.lastSheering = lastSheering;
    }
    
    @Override
    public void food(Food food) {
        System.out.println("Feeding sheep with: " + food.getDescription());
    }
    
    @Override
    public String toString() {
        return "Sheep{" +
                "lastSheering=" + lastSheering +
                ", " + super.toString() +
                '}';
    }
}