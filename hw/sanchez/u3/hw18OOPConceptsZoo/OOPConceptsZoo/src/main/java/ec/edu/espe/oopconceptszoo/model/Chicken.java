/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oopconceptszoo.model;

import java.util.Date;

/**
 * @author Joel Sanchez, The Softwarriors, @ESPE
 *
 */
public class Chicken extends FarmAnimal {
    private boolean isMolting;
    private int numberOfEggsPerWeek;
    
    public Chicken(int id, String breed, Date bornOn, float weight, boolean isMolting) {
        super(id, breed, bornOn, weight);
        this.isMolting = isMolting;
        this.numberOfEggsPerWeek = 0;
    }
    
    public boolean isMolting() {
        return isMolting;
    }
    
    public void setMolting(boolean molting) {
        isMolting = molting;
    }
    
    public int getNumberOfEggsPerWeek() {
        return numberOfEggsPerWeek;
    }
    
    public void setNumberOfEggsPerWeek(int numberOfEggsPerWeek) {
        this.numberOfEggsPerWeek = numberOfEggsPerWeek;
    }
    
    public int layAnEgg() {
        if (!isMolting) {
            numberOfEggsPerWeek++;
            return 1;
        } else {
            return 0;
        }
    }
    
    @Override
    public void food(Food food) {
        System.out.println("Feeding chicken with: " + food.getDescription());
    }
    
    @Override
    public String toString() {
        return "Chicken{" +
                "isMolting=" + isMolting +
                ", numberOfEggsPerWeek=" + numberOfEggsPerWeek +
                ", " + super.toString() +
                '}';
    }
}