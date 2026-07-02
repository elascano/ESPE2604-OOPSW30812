/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmsystem.model;

import ec.edu.espe.animalfarmsystem.controller.IMeatAnimal;
import ec.edu.espe.animalfarmsystem.controller.IProduceAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class Cow extends FarmAnimal implements IMeatAnimal, IProduceAnimal {
    private boolean producingMilk;
    private float carcassYield;

    public Cow(boolean producingMilk, float carcassYield, int id, String breed, Date bornOn, float Weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cuts) {
        super(id, breed, bornOn, Weight, slaughterHouse, product, cuts);
        this.producingMilk = producingMilk;
        this.carcassYield = carcassYield;
    }

    public float milk() {
        return this.producingMilk ? 15.5f : 0.0f; 
    }

    public boolean isProducingMilk() {
        return this.producingMilk;
    }

    public float calculateMeatYield() {
        return (this.getWeight() * this.carcassYield) / 100;
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cutsList = new ArrayList<>();
        float estimatedCutWeight = calculateMeatYield() / 4; 

        cutsList.add(new Cut(1, "Tenderloin", "Tender cut from the upper spine", estimatedCutWeight));
        cutsList.add(new Cut(2, "Ribeye", "Marbled rib section cut", estimatedCutWeight));
        cutsList.add(new Cut(3, "Ribs", "Bony section from the chest", estimatedCutWeight));
        cutsList.add(new Cut(4, "Flank Steak", "Transverse cut from the abdominal muscles", estimatedCutWeight));
        
        this.setCuts(cutsList); 
        return cutsList;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        this.slaughterHouse = slaughterHouse;
    }

    @Override
    public Product produce() {
        if (this.producingMilk) {
            if (this.getProduct() == null) {
                Product milkProduct = new Product(101, "Whole Milk", "Liters", 0.0f);
                this.setProduct(milkProduct);
            }
            return this.getProduct();
        }
        return null;
    }

    @Override
    public void measureQuantity(String unit, float quantity) {
        Product currentProduct = this.produce();
        if (currentProduct != null) {
            currentProduct.setUnit(unit);
            currentProduct.setQuantity(quantity);
        }
    }

    @Override
    public void feed(Food food) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param producingMilk the producingMilk to set
     */
    public void setProducingMilk(boolean producingMilk) {
        this.producingMilk = producingMilk;
    }

    /**
     * @return the carcassYield
     */
    public float getCarcassYield() {
        return carcassYield;
    }

    /**
     * @param carcassYield the carcassYield to set
     */
    public void setCarcassYield(float carcassYield) {
        this.carcassYield = carcassYield;
    }

    @Override
    public String toString() {
        return "Cow{" + super.toString() + ", producingMilk=" + producingMilk + ", carcassYield=" + carcassYield + '}';
    }
}