/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.farmsystem.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Joel Sanchez, The_Softwarriors ,@ESPE
 */
public abstract class FarmAnimal {
    private int id;
    private String breed;
    private Date bornOn;
    private float weight;
    protected SlaughterHouse slaughterHouse;
    private Product product;
    private ArrayList<Cut> cuts;
    
    public int getAgeInMonths(){
      if (bornOn == null) {
        throw new IllegalStateException("The birth date has not been assigned.");
    }

    LocalDate birthDate = bornOn.toInstant()
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate();

    LocalDate today = LocalDate.now();

    if (birthDate.isAfter(today)) {
        throw new IllegalArgumentException("The birth date cannot be in the future.");
    }

    return Math.toIntExact(ChronoUnit.MONTHS.between(birthDate, today));
      //code to compute the months based on the bornOnDate and current date
   
    }
    public abstract void feed (Food food);

    @Override
    public String toString() {
        return "FarmAnimal{" + "id=" + id + ", breed=" + breed + ", bornOn=" + bornOn + ", weight=" + weight + ", slaughterHouse=" + slaughterHouse + ", product=" + product + ", cuts=" + cuts + '}';
    }

    
    public FarmAnimal(int id, String breed, Date bornOn, float weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cuts) {
        this.id = id;
        this.breed = breed;
        this.bornOn = bornOn;
        this.weight = weight;
        this.slaughterHouse = slaughterHouse;
        this.product = product;
        this.cuts = cuts;
    }

    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * @param breed the breed to set
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * @return the bornOn
     */
    public Date getBornOn() {
        return bornOn;
    }

    /**
     * @param bornOn the bornOn to set
     */
    public void setBornOn(Date bornOn) {
        this.bornOn = bornOn;
    }

    /**
     * @return the weight
     */
    public float getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * @return the slaughterHouse
     */
    public SlaughterHouse getSlaughterHouse() {
        return slaughterHouse;
    }

    /**
     * @param slaughterHouse the slaughterHouse to set
     */
    public void setSlaughterHouse(SlaughterHouse slaughterHouse) {
        this.slaughterHouse = slaughterHouse;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the cuts
     */
    public ArrayList<Cut> getCuts() {
        return cuts;
    }

    /**
     * @param cuts the cuts to set
     */
    public void setCuts(ArrayList<Cut> cuts) {
        this.cuts = cuts;
    }

    
}