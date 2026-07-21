/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.animalfarm.model;

import java.util.Date;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
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
