package ec.edu.espe.farmsystem.model;

import ec.edu.espe.farmsystem.controller.IMeatAnimal;
import ec.edu.espe.farmsystem.controller.IProduceAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Joel Sanchez, The_Softwarriors ,@ESPE
 */

public class Sheep extends FarmAnimal implements IMeatAnimal, IProduceAnimal {
    private Date lastSheering;
    private float kgOfWool;
    
    public void shear() {
        System.out.println("Shearing the sheep...");
        System.out.println("Wool obtained: " + kgOfWool + " kg");
        lastSheering = new Date();
    }

    public Sheep(Date lastSheering, float kgOfWool, int id, String breed, Date bornOn, float weight, 
                 SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cuts) {
        super(id, breed, bornOn, weight, slaughterHouse, product, cuts);
        this.lastSheering = lastSheering;
        this.kgOfWool = kgOfWool;
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding Sheep with: " + food.getDescription());
        this.setWeight(this.getWeight() + 0.3f);
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts = new ArrayList<>();
        System.out.println("=== LAMB CUTS ===");
        cuts.add(new Cut(1, "Rack", "Cut from the rib", 1.5f));
        cuts.add(new Cut(2, "Leg", "Cut from the hind leg", 2.0f));
        cuts.add(new Cut(3, "Shoulder", "Cut from the front leg", 1.8f));
        cuts.add(new Cut(4, "Chop", "Cut from the loin", 1.2f));
        this.setCuts(cuts);
        return cuts;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        System.out.println("Sending SHEEP to slaughterhouse: " + slaughterHouse.getName());
        this.slaughterHouse = slaughterHouse;
    }

    @Override
    public Product produce() {
        Product wool = new Product(301, "Sheep Wool", "Kilograms", kgOfWool);
        this.setProduct(wool);
        System.out.println("Wool produced: " + kgOfWool + " kg");
        return wool;
    }

    @Override
    public void measureQuantity(String unit, float quantity) {
        System.out.println("Measuring: " + quantity + " " + unit);
        if (this.getProduct() != null) {
            this.getProduct().setUnit(unit);
            this.getProduct().setQuantity(quantity);
        }
    }

    public Date getLastSheering() {
        return lastSheering;
    }

    public void setLastSheering(Date lastSheering) {
        this.lastSheering = lastSheering;
    }

    public float getKgOfWool() {
        return kgOfWool;
    }

    public void setKgOfWool(float kgOfWool) {
        this.kgOfWool = kgOfWool;
    }
}