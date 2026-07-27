/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.hw18farm.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import org.bson.Document;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public abstract class FarmAnimal {
    protected int id;
    protected String breed;
    protected LocalDate bornOnDate;
    protected float weight;

    public FarmAnimal(int id, String breed, LocalDate bornOnDate, float weight) {
        this.id = id;
        this.breed = breed;
        this.bornOnDate = bornOnDate;
        this.weight = weight;
    }

    public abstract Document toDocument();

    public int getAgeInMonths() {
        LocalDate today = LocalDate.now();
        Period period = Period.between(bornOnDate, today);

        int ageInMonths = period.getYears() * 12 + period.getMonths();
        
        return ageInMonths;
    }

    public abstract boolean feed(Food food);

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

    public LocalDate getBornOnDate() {
        return bornOnDate;
    }

    public void setBornOnDate(LocalDate bornOnDate) {
        this.bornOnDate = bornOnDate;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
