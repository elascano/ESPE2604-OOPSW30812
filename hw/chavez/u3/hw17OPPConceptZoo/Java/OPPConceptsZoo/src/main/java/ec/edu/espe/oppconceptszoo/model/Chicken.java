/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oppconceptszoo.model;

import java.util.Date;

/**
 *
 * @author Odalys Chavez , CodeBreakers, @ESPE
 */
public class Chicken extends FarmAnimal {

     private int eggsPerWeek;

    public Chicken(int eggsPerWeek, int id, String breed, Date bornOn, float weight) {
        super(id, breed, bornOn, weight);
        this.eggsPerWeek = eggsPerWeek;
    }

    public int layEggs() {
        return eggsPerWeek;
    }

    public int getEggsPerWeek() {
        return eggsPerWeek;
    }

    public void setEggsPerWeek(int eggsPerWeek) {
        this.eggsPerWeek = eggsPerWeek;
    }

    @Override
    public String toString() {
        return "Chicken{" +
                "eggsPerWeek=" + eggsPerWeek +
                "} " + super.toString();
    }

    
    
}
