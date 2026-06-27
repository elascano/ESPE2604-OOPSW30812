/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.model;

import java.util.Date;

/**
 *
 * @author Cristian
 */
public class Chicken extends FarmAnimal{
    private boolean isMolting;
    private int numberOfEggs;

    public Chicken(boolean isMolting, int numberOfEggs, int id, String breed, Date bornOnDate, float weight) {
        super(id, breed, bornOnDate, weight);
        this.isMolting = isMolting;
        this.numberOfEggs = numberOfEggs;
    }
    
    public void layAnEgg(){
    
    }
    
    @Override
    public void feed(Food food) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean isIsMolting() {
        return isMolting;
    }

    public void setIsMolting(boolean isMolting) {
        this.isMolting = isMolting;
    }

    public int getNumberOfEggs() {
        return numberOfEggs;
    }

    public void setNumberOfEggs(int numberOfEggs) {
        this.numberOfEggs = numberOfEggs;
    }
}
