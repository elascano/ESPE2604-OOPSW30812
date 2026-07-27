/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.animalfarrmsystem.model;

import ec.edu.espe.animalfarrmsystem.controller.IMeatAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ronald Tipan, The_Softwarriors ,@ESPE
 */
public class Pig extends FarmAnimal implements IMeatAnimal {
    private float idealWeight;

    @Override
    public void feed(Food food) {
        System.out.println("Feeding THE PIG with food -->" + food +"in a bowl and water");
    }
    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut>cuts;
        cuts = new ArrayList<>();
        return cuts;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        this.slaughterHouse = slaughterHouse; 
    }
    
    public Pig(float idealWeight, int id, String breed, Date bornOn, float weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cuts) {
        super(id, breed, bornOn, weight, slaughterHouse, product, cuts);
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

    public boolean isReadyForSlaughter() {
    return getWeight() >= idealWeight;
    }
}
    