package ec.edu.espe.oopconceptszoo.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 * Abstract base class for all farm animals.
 *
 * @author Didier Elbay
 */
public abstract class FarmAnimal {

    private int id;
    private String breed;
    private Date bornOn;
    private float weight;

    public FarmAnimal(int id, String breed, Date bornOn, float weight) {
        this.id = id;
        this.breed = breed;
        this.bornOn = bornOn;
        this.weight = weight;
    }

    /**
     * Calculates and returns the animal's age in months based on bornOn.
     */
    public int getAgeInMonths() {
        LocalDate birth = bornOn.toInstant()
                .atZone(java.time.ZoneId.systemDefault())
                .toLocalDate();
        return Period.between(birth, LocalDate.now()).getMonths()
                + Period.between(birth, LocalDate.now()).getYears() * 12;
    }

    public void feed(Food food) {
        System.out.println("Animal " + id + " is eating " + food.getDescription());
    }

    public int getId()       { return id; }
    public String getBreed() { return breed; }
    public Date getBornOn()  { return bornOn; }
    public float getWeight() { return weight; }
    public void setWeight(float weight) { this.weight = weight; }
}
