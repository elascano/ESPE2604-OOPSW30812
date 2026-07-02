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
 * @author Adrian Vizcaino, The Softwarriors, @ESPE
 */
public class Pig extends FarmAnimal implements IMeatAnimal {
    private float idealWeight;
    
        @Override
    public SlaughterHouse sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        this.setSlaughterHouse(slaughterHouse);
        return slaughterHouse;
    }

    @Override
    public void feed(Food food) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts;
        cuts = new ArrayList<>();
        return cuts;
    }
    
    

    public Pig(float idealWeight, int id, String breed, Date bornOn, float Weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cuts) {
        super(id, breed, bornOn, Weight, slaughterHouse, product, cuts);
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

    
}
