package ec.edu.espe.farm.model;

import java.util.Date;

/**
 * @author Collahuazo Brandon, CodeBros, @ESPE
 */
public abstract class FarmAnimal {

  
    private int id;
    private String breed;
    private Date bornOn;
    private float weight;
    private Health health;

    public FarmAnimal() {
    }

 
    public FarmAnimal(int id, String breed, Date bornOn, float weight, Health health) {
        this.id = id;
        this.breed = breed;
        this.bornOn = bornOn;
        this.weight = weight;
        this.health = health;
    }

  
    public void feed(Food food) {
   
    }

 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Date getBornOn() {
        return bornOn;
    }

    public void setBornOn(Date bornOn) {
        this.bornOn = bornOn;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Animal ID: " + this.id + " | Breed: " + this.breed + " | Weight: " + this.weight + "kg";
    }
}
