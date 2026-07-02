/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.farmanimalsystem.model;

import ec.espe.edu.farmanimalsystem.controller.IMeatAnimal;
import ec.espe.edu.farmanimalsystem.controller.IProduceAnimal;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author Cristian
 */
public class Cow extends FarmAnimal implements IMeatAnimal, IProduceAnimal{
    private boolean isProducingMilk;
    private SlaughterHouse slaughterHouse;
    private float milkDaily;
    
    public Cow(float milkDaily, boolean isProducingMilk, int id, String breed, LocalDate bornOn, float weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cut) {
        super(id, breed, bornOn, weight, slaughterHouse, product, cut);
        this.milkDaily = milkDaily;
        this.isProducingMilk = isProducingMilk;
    }
    /**
     * @return the isProducingMilk
     */
    public boolean isIsProducingMilk() {
        return isProducingMilk;
    }

    /**
     * @param isProducingMilk the isProducingMilk to set
     */
    public void setIsProducingMilk(boolean isProducingMilk) {
        this.isProducingMilk = isProducingMilk;
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
     * @return the milkDaily
     */
    public float getMilkDaily() {
        return milkDaily;
    }

    /**
     * @param milkDaily the milkDaily to set
     */
    public void setMilkDaily(float milkDaily) {
        this.milkDaily = milkDaily;
        if (this.milkDaily <= 0) {
            this.isProducingMilk = false;
        }
    }
    
    public float getMonthlyMilkProduction() {
        if (!isProducingMilk) {
            return 0.0f;
        }
        return this.milkDaily * 30.0f;
    }
    
    public void checkProductionStatus(SlaughterHouse place) {
        if (!this.isProducingMilk || this.milkDaily <= 0) {
            sendToSlaughterHouse(place);
            System.out.println("The cow is no longer productive. Dispatched to slaughterhouse.");
        }
    }
    
    public void feed(Food food) {
        System.out.println("Feeding grass to the cow: " + food);
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> beefCuts = new ArrayList<>();
        return beefCuts;
    }
    
     @Override
    public SlaughterHouse sendToSlaughterHouse(SlaughterHouse slaughterhouse) {
        this.slaughterHouse = slaughterHouse;
        return null;
    }

    @Override
    public Product produce() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void measureQuality(String unit, float quantity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
