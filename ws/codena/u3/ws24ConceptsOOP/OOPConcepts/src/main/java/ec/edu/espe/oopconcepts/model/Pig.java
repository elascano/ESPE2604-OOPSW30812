/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oopconcepts.model;

import ec.edu.espe.oopconcepts.controller.IMeatAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Pig extends FarmAnimal implements IMeatAnimal{
    
    private float idealWeight;

    public Pig(float idealWeight, int id, String breed, Date bornOnDate, float weight) {
        super(id, breed, bornOnDate, weight);
        this.idealWeight = idealWeight;
    }
    
    
    public void sendToButcher(){
        //TODO
    }
    
    @Override
    public void feed(Food food) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cut> cut() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public float getIdealWeight() {
        return idealWeight;
    }

    public void setIdealWeight(float idealWeight) {
        this.idealWeight = idealWeight;
    }
    
}
