/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmsystem.model;

import ec.edu.espe.animalfarmsystem.controller.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Cow extends FarmAnimal implements IMeatAnimal, IProduceAnimal {

    private boolean isProducingMilk;
    private float quantityOfMilk;

    public Cow(boolean isProducingMilk, float quantityOfMilk, int id, String breed, Date bornOnDate, float weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cuts) {
        super(id, breed, bornOnDate, weight, slaughterHouse, product, cuts);
        this.isProducingMilk = isProducingMilk;
        this.quantityOfMilk = quantityOfMilk;
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding the COW with food --> " + food + " and water");
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts = new ArrayList<>();

        if (slaughterHouse.getName() == null) {
            System.out.println("First send the Cow to slaughterHouse");

        } else {

            cuts.add(new Cut(1, "Brisket", "Cow", 13.5F));
            cuts.add(new Cut(2, "Rib", "Cow", 34));
            cuts.add(new Cut(3, "Loin", "Cow", 58));
            cuts.add(new Cut(4, "Chuck", "Cow", 88));

            System.out.println("Cow has been cut");

            for (Cut cut : cuts) {
                System.out.println(cut.getDescription());
            }

        }

        return cuts;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        if (isProducingMilk) {
            System.out.println("The Cow is producing milk, it cannot be sent to slaughterHouse");

        } else {
            this.slaughterHouse = slaughterHouse;
            System.out.println("The Cow has been sent to SlaughterHouse " + slaughterHouse.getName());
        }
    }
    
    public float milk(){
        float milkProduced = weight/100;
        return milkProduced;
    }

    @Override
    public Product produce(int productId) {

        if (isProducingMilk) {
            product.setId(productId);
            product.setDescription("Milk");
            product.setUnit("L");
            product.setQuantity(milk());

            System.out.println("The cow produce " + product.getQuantity() + product.getUnit() + product.getDescription());
        } else {
            System.out.println("The cow cannot produce milk");
        }

        return product;
    }

    @Override
    public void measureQuantity(String unit, float quantity) {
        if (isProducingMilk) {
            product.setUnit(unit);
            product.setQuantity(quantity);

            quantityOfMilk += quantity;

            System.out.println("Measure: " + quantity + " " + unit + " of milk.");
        } else{
            System.out.println("The cow is not producing milk");
        }

    }

    public boolean isIsProducingMilk() {
        return isProducingMilk;
    }

    public void setIsProducingMilk(boolean isProducingMilk) {
        this.isProducingMilk = isProducingMilk;
    }

    public float getQuantityOfMilk() {
        return quantityOfMilk;
    }

    public void setQuantityOfMilk(float quantityOfMilk) {
        this.quantityOfMilk = quantityOfMilk;
    }

}
