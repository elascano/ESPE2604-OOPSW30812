/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmsystem.model;

import ec.edu.espe.animalfarmsystem.controller.IProduceAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Chicken extends FarmAnimal implements IProduceAnimal {

    private boolean isMolting;
    private int numberOfEggsPerWeek;

    public Chicken(int id, String breed, Date bornOnDate, float weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cuts, boolean isMolting, int numberOfEggsPerWeek) {
        super(id, breed, bornOnDate, weight, slaughterHouse, product, cuts);
        this.isMolting = isMolting;
        this.numberOfEggsPerWeek = numberOfEggsPerWeek;
    }

    @Override
    public String toString() {
        return "Chicken{" + "isMolting=" + isMolting + ", numberOfEggsPerWeek=" + numberOfEggsPerWeek + '}';
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding the CHICKEN with food --> " + food);
    }

    public void layAnEgg() {

        if (isMolting) {
            System.out.println("\nThe chicken is molting, it cannot lay an egg\n");
        } else {
            setNumberOfEggsPerWeek(getNumberOfEggsPerWeek() + 1);
            System.out.println("\nThe chicken has laid an egg\n");
        }
    }

    @Override
    public Product produce(int productId) {
        
        product.setId(productId);
        product.setDescription("Eggs");
        product.setQuantity(numberOfEggsPerWeek);
        product.setUnit("");
        
        System.out.println("The chicken produced: " + getNumberOfEggsPerWeek() + "Eggs");
        return product;
    }

    @Override
    public void measureQuantity(String unit, float quantity) {
        if (isMolting) {
            System.out.println("The chicken is molting, it cannot produce eggs");

        } else{
            
            product.setUnit(unit);
            product.setQuantity(quantity);

            numberOfEggsPerWeek += quantity;

            System.out.println("Measure: " + quantity + " of eggs.");
        }
    }

    public boolean isIsMolting() {
        return isMolting;
    }

    public void setIsMolting(boolean isMolting) {
        this.isMolting = isMolting;
    }

    public int getNumberOfEggsPerWeek() {
        return numberOfEggsPerWeek;
    }

    public void setNumberOfEggsPerWeek(int numberOfEggsPerWeek) {
        this.numberOfEggsPerWeek = numberOfEggsPerWeek;
    }

}
