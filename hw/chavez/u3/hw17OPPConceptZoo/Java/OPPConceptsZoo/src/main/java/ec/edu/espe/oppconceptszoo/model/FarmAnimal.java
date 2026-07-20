/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oppconceptszoo.model;

import java.util.Date;

/**
 *
 * @author Odalys Chavez , CodeBreakers, @ESPE
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
    
    public int getAgeInMOnths(){
        //algorithm to compute the months based on the boron date
        return 12;   
    }
    public void feed(Food food) {
        System.out.println(
                getClass().getSimpleName()
                + " is eating "
                + food.getDescription());
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @return the breed
     */
    public String getBreed() {
        return breed;
    }  
    /**
     * @return the bornOn
     */
    public Date getBornOn() {
        return bornOn;
    }   
    /**
     * @return the weight
     */
    public float getWeight() {
        return weight;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setBornOn(Date bornOn) {
        this.bornOn = bornOn;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "FarmAnimal{" + "id=" + id + ", breed=" + breed + ", bornOn=" + bornOn + ", weight=" + weight + '}';
    }
    
    
}
