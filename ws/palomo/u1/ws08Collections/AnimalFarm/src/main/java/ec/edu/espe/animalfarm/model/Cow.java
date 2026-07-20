/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.animalfarm.model;

import ec.edu.espe.animalfarm.controller.IMeatAnimal;
import ec.edu.espe.animalfarm.controller.MongoConnection;
import java.util.ArrayList;
import java.util.Date;
import org.bson.Document;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class Cow extends FarmAnimal implements IMeatAnimal{
    boolean isProducingMilk;
    float milk;

    public Cow(int id, String breed, Date bornOn, float weight, boolean isProducingMilk, float milk) {
        super(id, breed, bornOn, weight);
        this.isProducingMilk = isProducingMilk;
        this.milk = milk;
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts = new ArrayList<>();
        cuts.add(new Cut(10, "T-Bone", "Rib Section", (float) (getWeight() * 0.20)));
        cuts.add(new Cut(11, "Ribeye", "Loin Section", (float) (getWeight() * 0.12)));
        return cuts;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterhouse) {
        System.out.println("Cow moving to house.");
    }

    public void saveToDatabase() {
        Document doc = new Document("id", getId())
                .append("breed", getBreed())
                .append("bornOn", getBornOn())
                .append("weight", getWeight())
                .append("isProducingMilk", isProducingMilk)
                .append("milk", milk);
        MongoConnection.saveDocument("cows", doc);
    }

    public boolean isProducingMilk() { return isProducingMilk; }
    public float milk() { return milk; }
}
