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
    private float premiumCutsPercentage;
    public Pig(float idealWeight, float premiumCutsPercentage, int id, String breed, Date bornOn, float Weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cuts) {
        super(id, breed, bornOn, Weight, slaughterHouse, product, cuts);
        this.idealWeight = idealWeight;
        this.premiumCutsPercentage = premiumCutsPercentage;
    }

    public boolean isReadyForSlaughter() {
        return false;
    }

    public float calculatePremiumCuts() {
        return 0.0f;
    }

    @Override 
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        this.slaughterHouse = slaughterHouse;
    }

    @Override
    public void feed(Food food) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cutsList = new ArrayList<>();
        return cutsList;
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
     * @return the premiumCutsPercentage
     */
    public float getPremiumCutsPercentage() {
        return premiumCutsPercentage;
    }

    /**
     * @param premiumCutsPercentage the premiumCutsPercentage to set
     */
    public void setPremiumCutsPercentage(float premiumCutsPercentage) {
        this.premiumCutsPercentage = premiumCutsPercentage;
    }

    @Override
    public String toString() {
        return "Pig{" + super.toString() + ", idealWeight=" + idealWeight + ", premiumCutsPercentage=" + premiumCutsPercentage + '}';
    }
}