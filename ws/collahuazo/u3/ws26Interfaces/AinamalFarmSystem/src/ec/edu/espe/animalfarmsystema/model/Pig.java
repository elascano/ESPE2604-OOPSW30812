/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmsystema.model;

import ec.edu.espe.animalfarmsystema.controller.IMeatAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Collahuazo Brandon,CodeBros,@ESPE
 */
public class Pig extends FarmAnimal implements IMeatAnimal {

    private float idealWeight;

    public Pig(float idealWeight, int id, String breed, Date bornOn, float weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cuts) {
        super(id, breed, bornOn, weight, slaughterHouse, product, cuts);
        this.idealWeight = idealWeight;
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding The Pig with food -->" + food + " in a bowl and water");
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> localCuts = new ArrayList<>();
        return localCuts;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        this.slaughterHouse = slaughterHouse;
    }

    public float getIdealWeight() {
        return idealWeight;
    }

    public void setIdealWeight(float idealWeight) {
        this.idealWeight = idealWeight;
    }

    @Override
    public String toString() {
        return "Pig{" + "idealWeight=" + idealWeight + ", " + super.toString() + '}';
    }

}
