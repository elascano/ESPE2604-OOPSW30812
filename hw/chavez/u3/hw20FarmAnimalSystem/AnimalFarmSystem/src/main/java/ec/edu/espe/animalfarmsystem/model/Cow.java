/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmsystem.model;

import ec.edu.espe.animalfarmsystem.controller.IMeatAnimal;
import ec.edu.espe.animalfarmsystem.controller.IProduceAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class Cow extends FarmAnimal implements IMeatAnimal, IProduceAnimal{
    private boolean producingMilk;
    private float dailyMilkLiters;

    public Cow(boolean producingMilk, float dailyMilkLiters, int id, String breed, Date bornOn, float weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cuts) {
        super(id, breed, bornOn, weight, slaughterHouse, product, cuts);
        this.producingMilk = producingMilk;
        this.dailyMilkLiters = dailyMilkLiters;
    }

    @Override
    public String toString() {
        return "Cow{" + "producingMilk=" + producingMilk + ", dailyMilkLiters=" + dailyMilkLiters + '}';
    }
    

    @Override
    public void feed(Food food) {
        System.out.println("The cow is eating " + food.getDescription());
        setWeight(getWeight() + 2.0f);
    }
    public float milk() {
        if (producingMilk) {
            return dailyMilkLiters;
        }
        return 0;
    }

    public float calculateMilkProduction() {
        return dailyMilkLiters * 30;
    }

    @Override
    public ArrayList<Cut> cut() {
         return getCuts();
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaugtherHouse) {
        this.slaughterHouse = slaugtherHouse;
    }

    @Override
    public Product produce() {
        return getProduct();
    }

    @Override
    public void measureQuantity(String unit, float quantity) {
        System.out.println("Quantity: " + quantity + " " + unit);
    }
   

    /**
     * @return the producingMilk
     */
    public boolean isProducingMilk() {
        return producingMilk;
    }

    /**
     * @param producingMilk the producingMilk to set
     */
    public void setProducingMilk(boolean producingMilk) {
        this.producingMilk = producingMilk;
    }

    /**
     * @return the dailyMilkLiters
     */
    public float getDailyMilkLiters() {
        return dailyMilkLiters;
    }

    /**
     * @param dailyMilkLiters the dailyMilkLiters to set
     */
    public void setDailyMilkLiters(float dailyMilkLiters) {
        this.dailyMilkLiters = dailyMilkLiters;
    }
    
    
    }
    