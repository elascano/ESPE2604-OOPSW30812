package ec.edu.espe.oopconceptszoo.model;

import java.util.Date;

/**
 * @author Joel Sanchez, The Softwarriors, @ESPE
 *
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
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }
    public Date getBornOn() { return bornOn; }
    public void setBornOn(Date bornOn) { this.bornOn = bornOn; }
    public float getWeight() { return weight; }
    public void setWeight(float weight) { this.weight = weight; }
    
    public int getAgeInMonths() {
        Date now = new Date();
        long diff = now.getTime() - bornOn.getTime();
        long months = diff / (1000L * 60 * 60 * 24 * 30);
        return (int) months;
    }
    
    public abstract void food(Food food);
    
    @Override
    public String toString() {
        return "FarmAnimal{" +
                "id=" + id +
                ", breed='" + breed + '\'' +
                ", bornOn=" + bornOn +
                ", weight=" + weight +
                '}';
    }
}
