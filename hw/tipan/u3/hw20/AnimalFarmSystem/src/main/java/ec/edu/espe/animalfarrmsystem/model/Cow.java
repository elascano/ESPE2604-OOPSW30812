/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarrmsystem.model;

import ec.edu.espe.animalfarrmsystem.controller.IProduceAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ronal
 */
   public class Cow extends FarmAnimal implements IProduceAnimal {

    private float productionInLiters;
    private float quality;

    public Cow(float productionInLiters, float quality, int id,
            String breed, Date bornOn, float weight,
            SlaughterHouse slaughterHouse,
            Product product,
            ArrayList<Cut> cuts) {

        super(id, breed, bornOn, weight, slaughterHouse, product, cuts);

        this.productionInLiters = productionInLiters;
        this.quality = quality;
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding the cow with " + food + " and grass");
    }

    @Override
    public Product produce() {
        return getProduct();
    }

    @Override
    public void measureQuantity(String unit, float quantity) {
        System.out.println("Production: " + quantity + " " + unit);
    }

    public float getProductionInLiters() {
        return productionInLiters;
    }

    public void setProductionInLiters(float productionInLiters) {
        this.productionInLiters = productionInLiters;
    }

    public float getQuality() {
        return quality;
    }

    public void setQuality(float quality) {
        this.quality = quality;
    }
}

