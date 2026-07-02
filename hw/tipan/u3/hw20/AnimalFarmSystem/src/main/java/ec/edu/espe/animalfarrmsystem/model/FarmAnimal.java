/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//give a method to compute the age in moths based on date varisble in java , the method recives and argument of type 
//no arguments for the method, 
//resolver el pig y el cow
package ec.edu.espe.animalfarrmsystem.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ronald Tipan, The_Softwarriors ,@ESPE
 */
public abstract class FarmAnimal {
    private int id;
    private String breed;
    private Date bornOn;
    private float weight;
    protected SlaughterHouse slaughterHouse;
    private Product product;
    private ArrayList<Cut>cuts;

    public FarmAnimal(int id, String breed, Date bornOn, float weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cuts) {
        this.id = id;
        this.breed = breed;
        this.bornOn = bornOn;
        this.weight = weight;
        this.slaughterHouse = slaughterHouse;
        this.product = product;
        this.cuts = cuts;
    }
    public int getAgeInMonths(){
       
        //cod3e to compute the age based on bornOnDate and current date
        return 1;
    }
    
    public abstract void feed(Food food);
    
    
    @Override
    public String toString() {
        return "FarmAnimal{" + "id=" + id + ", breed=" + breed + ", bornOn=" + bornOn + ", weight=" + weight + ", slaughterHouse=" + slaughterHouse + ", product=" + product + ", cuts=" + cuts + '}';
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
