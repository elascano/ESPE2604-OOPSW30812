/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmsystem.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public abstract class FarmAnimal {
    private int id;
    private String bread;
    private Date bornOn;
    private float weight;
    private SlaughterHouse  slaughterhouse;
    private Product product;
    private ArrayList<Cut> cuts;
    
    
public int gerAgeinMonths(){
    // code to compute the age bassed on bornOnDate and current date
    return 1;
}
public abstract void feed(Food food);
    @Override
    public String toString() {
        return "FarmAnimal{" + "id=" + getId() + ", bread=" + getBread() + ", bornOn=" + getBornOn() + ", weight=" + getWeight() + '}';
    }

    public FarmAnimal(int id, String bread, Date bornOn, float weight, SlaughterHouse slaughterhouse, Product product, ArrayList<Cut> cuts) {
        this.id = id;
        this.bread = bread;
        this.bornOn = bornOn;
        this.weight = weight;
        this.slaughterhouse = slaughterhouse;
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
     * @return the bread
     */
    public String getBread() {
        return bread;
    }

    /**
     * @param bread the bread to set
     */
    public void setBread(String bread) {
        this.bread = bread;
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
     * @return the slaughterhouse
     */
    public SlaughterHouse getSlaughterhouse() {
        return slaughterhouse;
    }

    /**
     * @param slaughterhouse the slaughterhouse to set
     */
    public void setSlaughterhouse(SlaughterHouse slaughterhouse) {
        this.slaughterhouse = slaughterhouse;
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
