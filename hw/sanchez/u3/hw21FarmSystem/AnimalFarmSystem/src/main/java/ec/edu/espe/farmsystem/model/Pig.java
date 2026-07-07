/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.farmsystem.model;

import ec.edu.espe.farmsystem.controller.IMeatAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Joel Sanchez, The_Softwarriors ,@ESPE
 */
public class Pig extends FarmAnimal implements IMeatAnimal{
    private float idealWeight;   

    @Override
    public void feed(Food food) {
        System.out.println("Feeding THE PIG with food -->"  + food + "in a bowl and water");
 
    }
    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts = new ArrayList<>();
        System.out.println("");
        
        cuts.add(new Cut(1, "Pork Chop", "Cut from the loin", 2.0f));
        cuts.add(new Cut(2, "Bacon", "Cut from the belly", 3.0f));
        cuts.add(new Cut(3, "Ham", "Cut from the hind leg", 4.0f));
        cuts.add(new Cut(4, "Shoulder", "Cut from the front leg", 4.5f));
        
        this.setCuts(cuts);
        return cuts;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaugtherHouse) {
        this.slaughterHouse = slaugtherHouse;
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

    
    
    
}
