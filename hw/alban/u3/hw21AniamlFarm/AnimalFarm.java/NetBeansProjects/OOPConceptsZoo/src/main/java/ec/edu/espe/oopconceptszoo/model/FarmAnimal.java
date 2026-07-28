package ec.edu.espe.oopconceptszoo.model;

import java.util.Date;

public abstract class FarmAnimal {
    int id;
    String breed;
    Date bornOn;
    float weight;

    public FarmAnimal(int id, String breed, Date bornOn, float weight) {
        this.id = id;
        this.breed = breed;
        this.bornOn = bornOn;
        this.weight = weight;
    }

    public int getAgeInMonths() {
        return 12;
    }

    public void feed(Food food) {
        System.out.println("Animal " + id + " fed.");
    }

    public int getId() { return id; }
    public String getBreed() { return breed; }
    public Date getBornOn() { return bornOn; }
    public float getWeight() { return weight; }
}