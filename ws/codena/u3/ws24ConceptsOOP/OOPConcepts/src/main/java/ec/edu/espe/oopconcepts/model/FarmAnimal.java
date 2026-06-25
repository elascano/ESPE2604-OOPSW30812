/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oopconcepts.model;

import java.util.Date;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public abstract class FarmAnimal {
    protected int id;
    protected String breed;
    protected Date bornOnDate;
    protected float weight;

    public FarmAnimal(int id, String breed, Date bornOnDate, float weight) {
        this.id = id;
        this.breed = breed;
        this.bornOnDate = bornOnDate;
        this.weight = weight;
    }
    
    
    
    public int getAgeInMonths(){
        //TODO Algorithm to compute the monts based on date
        return 0;
    }
    
    public abstract void feed(Food food);

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

    public Date getBornOnDate() {
        return bornOnDate;
    }

    public void setBornOnDate(Date bornOnDate) {
        this.bornOnDate = bornOnDate;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    
    
}
