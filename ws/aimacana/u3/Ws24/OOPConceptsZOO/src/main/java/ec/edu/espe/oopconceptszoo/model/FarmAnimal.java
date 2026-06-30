package ec.edu.espe.oopconceptszoo.model;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Ronald Tipan <The_Softwarrios at ESPE>
 */
public abstract class FarmAnimal {
    private int id;
    private String breed;
    private LocalDate bornOn;
    private float weight;
    
    public FarmAnimal(int id, String breed, LocalDate bornOn, float weight) {
        this.id = id;
        this.breed = breed;
        this.bornOn = bornOn;
        this.weight = weight;
    }
    
    public int getAgeInMonths(){
        if(bornOn == null) return 0;
        Period period = Period.between(bornOn, LocalDate.now());
        return period.getYears() * 12 + period.getMonths();
    }
    
    public abstract void feed(Food food);

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }

    public LocalDate getBornOn() { return bornOn; }
    public void setBornOn(LocalDate bornOn) { this.bornOn = bornOn; }

    public float getWeight() { return weight; }
    public void setWeight(float weight) { this.weight = weight; }
}
