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
public class Sheep extends FarmAnimal implements IProduceAnimal {

    private Date lastShearing;
    private float quantityOfWool;

    public Sheep(int id, String breed, Date bornOnDate, float weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cuts, Date lastShearing, float quantityOfWool) {
        super(id, breed, bornOnDate, weight, slaughterHouse, product, cuts);
        this.lastShearing = lastShearing;
        this.quantityOfWool = quantityOfWool;
    }

    @Override
    public String toString() {
        return "Sheep{" + "lastShearing=" + getLastShearing() + '}';
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding the SHEEP with food --> " + food + " and water");
    }

    public float shear() {
        float woolProduced = weight / 150;
        return woolProduced;
    }

    @Override
    public Product produce(int productId) {
        product.setId(productId);
        product.setDescription("Wool");
        product.setUnit("Kg");
        product.setQuantity(shear());

        System.out.println("The sheep produce " + product.getQuantity() + "kg of wool");

        return product;
    }

    @Override
    public void measureQuantity(String unit, float quantity) {
        product.setUnit(unit);
        product.setQuantity(quantity);

        quantityOfWool += quantity;

        System.out.println("Measure: " + quantity + " " + unit + " of wool.");
    }

    public Date getLastShearing() {
        return lastShearing;
    }

    public void setLastShearing(Date lastShearing) {
        this.lastShearing = lastShearing;
    }

    public float getQuantityOfWool() {
        return quantityOfWool;
    }

    public void setQuantityOfWool(float quantityOfWool) {
        this.quantityOfWool = quantityOfWool;
    }

}
