/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmsystema.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Collahuazo Brandon,CodeBros,@ESPE
 */
public abstract class FarmAnimal {
    private int id;
    private String breed;
    private Date bornOn;
    private float weight;
    protected SlaughterHouse slaughterHouse;
    private Product product;
    private ArrayList<Cut> cuts;

    public int gerAgeInMonths(){
        // code t ocompute the age based on bornOnDate and current date
        return 1; 
    }
    
    public abstract void feed(Food food);

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

   
    public SlaughterHouse getSlaughterHouse() {
        return slaughterHouse;
    }

    
    public void setSlaughterHouse(SlaughterHouse slaughterHouse) {
        this.slaughterHouse = slaughterHouse;
    }

    public Product getProduct() {
        return product;
    }

 
    public void setProduct(Product product) {
        this.product = product;
    }

 
    public ArrayList<Cut> getCuts() {
        return cuts;
    }

 
    public void setCuts(ArrayList<Cut> cuts) {
        this.cuts = cuts;
    }
    
    
}
