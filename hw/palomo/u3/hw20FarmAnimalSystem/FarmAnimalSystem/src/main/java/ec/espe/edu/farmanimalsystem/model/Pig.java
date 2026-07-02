/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.farmanimalsystem.model;

import java.time.LocalDate;
import java.util.ArrayList;
import ec.espe.edu.farmanimalsystem.controller.IMeatAnimal;

/**
 *
 * @author Cristian
 */
public class Pig extends FarmAnimal implements IMeatAnimal{
    private float idealWeight;
    private SlaughterHouse slaughterHouse;
    
     public Pig(float idealWeight, int id, String breed, LocalDate bornOn, float weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cut) {
        super(id, breed, bornOn, weight, slaughterHouse, product, cut);
        this.idealWeight = idealWeight;
    }
    /**
     * @return the idealWeight
     */
    public float getIdealWeight() {
        return idealWeight;
    }

    /**
     * @param idealWeight the idealWeight to set
     */
    public void setIdealWeight(float idealWeight) {
        this.idealWeight = idealWeight;
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
    
     @Override
    public SlaughterHouse sendToSlaughterHouse(SlaughterHouse slaughterhouse) {
        this.slaughterHouse = slaughterHouse;
        return null;
    }
    
     @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts;
        cuts = new ArrayList<>();
        return cuts;
    }
    
    public void feed(Food food) {
        System.out.println("Feedin THE PIG with food --> " + food + "in a bowl and water");
    }
}
