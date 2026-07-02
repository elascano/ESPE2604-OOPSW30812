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
 * @author Jennyfer Nase
 */
public class Pig extends FarmAnimal  implements IMeatAnimal {
    private float idealWeight;

    @Override
    public void feed(Food food) {
        System.out.println("Feeding The PIG with food --> "+ food + "in a bowl and water");
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
    
    public Pig(float idealWeight, int id, String breed, Date bornOn, float weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cut) {
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


}
