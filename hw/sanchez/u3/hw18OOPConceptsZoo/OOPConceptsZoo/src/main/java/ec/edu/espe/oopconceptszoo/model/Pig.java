/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oopconceptszoo.model;

import ec.edu.espe.oopconceptszoo.controller.IMeatAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Joel Sanchez, The Softwarriors, @ESPE
 *
 */
public class Pig extends FarmAnimal implements IMeatAnimal {
    private float idealWeight;
    
    public Pig(int id, String breed, Date bornOn, float weight, float idealWeight) {
        super(id, breed, bornOn, weight);
        this.idealWeight = idealWeight;
    }
    
    public float getIdealWeight() {
        return idealWeight;
    }
    
    public void setIdealWeight(float idealWeight) {
        this.idealWeight = idealWeight;
    }
    
    public boolean isReadyForSlaughter() {
        return getWeight() >= idealWeight;
    }
    
    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts = new ArrayList<>();
        cuts.add(new Cut(1, "Loin", "Pork loin cut", 4.0f));
        cuts.add(new Cut(2, "Bacon", "Bacon cut", 3.0f));
        cuts.add(new Cut(3, "Ham", "Ham cut", 6.0f));
        return cuts;
    }
    
    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        System.out.println("Sending pig to slaughter house: " + slaughterHouse);
    }
    
    @Override
    public void food(Food food) {
        System.out.println("Feeding pig with: " + food.getDescription());
    }
    
    @Override
    public String toString() {
        return "Pig{" +
                "idealWeight=" + idealWeight +
                ", " + super.toString() +
                '}';
    }
}