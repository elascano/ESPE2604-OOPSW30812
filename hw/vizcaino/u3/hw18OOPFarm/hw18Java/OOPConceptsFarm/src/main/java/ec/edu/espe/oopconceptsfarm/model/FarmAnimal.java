/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oopconceptsfarm.model;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;

public abstract class FarmAnimal {

    protected int id;
    protected String breed;
    protected Date bornOn;
    protected float weight;
    protected String healthStatus;

    protected ArrayList<Cut> cuts;

    public FarmAnimal() {
        cuts = new ArrayList<>();
    }

    public FarmAnimal(int id,
            String breed,
            Date bornOn,
            float weight,
            String healthStatus) {

        this.id = id;
        this.breed = breed;
        this.bornOn = bornOn;
        this.weight = weight;
        this.healthStatus = healthStatus;

        cuts = new ArrayList<>();
    }

    public int getAgeInMonths() {

        LocalDate birthDate = bornOn.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate currentDate = LocalDate.now();

        Period period = Period.between(birthDate, currentDate);

        return period.getYears() * 12 + period.getMonths();
    }

    public void feed(Food food) {
        weight += weight * 0.02f;
    }

    public void updateHealth(String status) {
        healthStatus = status;
    }

    public int getId() {
        return id;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getBreed() {
        return breed;
    }

    public Date getBornOn() {
        return bornOn;
    }

    public String getHealthStatus() {
        return healthStatus;
    }
}
