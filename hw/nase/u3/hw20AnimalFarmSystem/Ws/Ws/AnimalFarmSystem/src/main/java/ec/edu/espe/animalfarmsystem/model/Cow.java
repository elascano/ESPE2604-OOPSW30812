/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmsystem.model;

import ec.edu.espe.animalfarmsystem.controller.IMeatAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sbart
 */
public class Cow extends FarmAnimal implements IMeatAnimal {
   private boolean isProducingMilk;
   private float milk;
   private SlaughterHouse slaughterHouse;
   
   
    public Cow(boolean isProducingMilk, float milk, int id, String breed, Date bornOn, float weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cut) {
        super(id, breed, bornOn, weight, slaughterHouse, product, cut);
        this.isProducingMilk = isProducingMilk;
        this.milk = milk;
    }
    
    public boolean isProducingMilk() {
        return this.isProducingMilk;
    }

    public float milk() {
        if (this.isProducingMilk) {
            return this.milk; 
        } else {
            System.out.println("This cow is not currently producing milk.");
            return 0.0f;
        }
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
     * @return the milk
     */
    public float getMilk() {
        return milk;
    }

    /**
     * @param milk the milk to set
     */
    public void setMilk(float milk) {
        this.milk = milk;
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding the COW with: " + food);
    }

    @Override
    public ArrayList<Cut> cut() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SlaughterHouse sendToSlaughterHouse(SlaughterHouse slaughterhouse) {
        this.slaughterHouse = slaughterHouse;
        return null;
    }
}
