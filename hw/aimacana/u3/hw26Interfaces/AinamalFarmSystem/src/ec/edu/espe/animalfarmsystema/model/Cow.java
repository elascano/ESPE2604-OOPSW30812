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
 * @author Anthony Aimacaña
 */
public class Cow extends FarmAnimal implements IMeatAnimal,IProductAnimal{
    private float producingMilk;
    private float milk;

    @Override
    public String toString() {
        return "Cow{" + super.toString() + ", producingMilk=" + producingMilk + ", milk=" + milk + '}';
    }

    public Cow(float producingMilk, float milk, int id, String breed, Date bornOn, float weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cuts) {
        super(id, breed, bornOn, weight, slaughterHouse, product, cuts);
        this.producingMilk = producingMilk;
        this.milk = milk;
    }

    /**
     * @return the producingMilk
     */
    public float getProducingMilk() {
        return producingMilk;
    }

    /**
     * @param producingMilk the producingMilk to set
     */
    public void setProducingMilk(float producingMilk) {
        this.producingMilk = producingMilk;
    }

    /**
     * @return the milk
     */
    public float getMilk() {
        return milk;
    }

    /**
     * @param milk the milk to set
     */
    public void setMilk(float milk) {
        this.milk = milk;
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding the cow with " + food);
    }

    @Override
    public ArrayList<Cut> cut() {
        return new ArrayList<Cut>();
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        this.slaughterHouse = slaughterHouse;
    }

    @Override
    public Product produce() {
        return new Product(1, "Milk", "Liters", this.milk);
    }

    @Override
    public void measureQuantity(String unit, float quantity) {
        System.out.println("Measuring " + quantity + " " + unit);
    }
    
}
