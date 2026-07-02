/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmsystema.model;

import ec.edu.espe.animalfarmsystema.controller.IMeatAnimal;
import ec.edu.espe.animalfarmsystema.controller.IProductAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Collahuazo Brandon,CodeBros,@ESPE
 */
public class Cow extends FarmAnimal implements IProductAnimal, IMeatAnimal {

    private boolean isProducingMilk;

    public Cow(boolean isProducingMilk, int id, String breed, Date bornOn, float weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cuts) {
        super(id, breed, bornOn, weight, slaughterHouse, product, cuts);
        this.isProducingMilk = isProducingMilk;
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding the Cow with food --> " + food + " in the pasture");
    }

    public float milk() {
        if (isProducingMilk()) { 
            return 3.1416f;
        }
        return 0.0f;
    }

    @Override
    public Product produce() {
        return this.getProduct();
    }

    @Override
    public void measureQuantity(String unit, float quantity) {
        System.out.println("Quantity of milk of cow: " + quantity + " " + unit);
    }

    @Override
    public ArrayList<Cut> cut() {
        return new ArrayList<>();
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        this.slaughterHouse = slaughterHouse;
    }

    @Override
    public String toString() {
        return "Cow{" + "isProducingMilk=" + isProducingMilk() + ", " + super.toString() + '}';
    }

    public boolean isProducingMilk() {
        return this.isProducingMilk;
    }

    public void setProducingMilk(boolean isProducingMilk) {
        this.isProducingMilk = isProducingMilk;
    }
}