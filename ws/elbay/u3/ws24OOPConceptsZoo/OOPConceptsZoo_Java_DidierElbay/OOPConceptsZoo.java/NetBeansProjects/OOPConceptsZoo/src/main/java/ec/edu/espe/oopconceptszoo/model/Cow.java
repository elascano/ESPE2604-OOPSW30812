package ec.edu.espe.oopconceptszoo.model;

import ec.edu.espe.oopconceptszoo.controller.IMeatAnimal;
import ec.edu.espe.oopconceptszoo.controller.MongoConnection;
import java.util.ArrayList;
import java.util.Date;
import org.bson.Document;

/**
 * Represents a cow in the farm. Implements IMeatAnimal.
 *
 * @author Didier Elbay
 */
public class Cow extends FarmAnimal implements IMeatAnimal {

    private boolean isProducingMilk;
    private float milkAmount;

    public Cow(int id, String breed, Date bornOn, float weight,
               boolean isProducingMilk, float milkAmount) {
        super(id, breed, bornOn, weight);
        this.isProducingMilk = isProducingMilk;
        this.milkAmount = milkAmount;
    }

    /**
     * Returns milk efficiency as a percentage of body weight.
     */
    public float getMilkEfficiency() {
        if (getWeight() <= 0) return 0f;
        return (milkAmount / getWeight()) * 100f;
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts = new ArrayList<>();
        cuts.add(new Cut(10, "T-Bone",  "Rib Section",  getWeight() * 0.20f));
        cuts.add(new Cut(11, "Ribeye",  "Loin Section", getWeight() * 0.12f));
        return cuts;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterhouse) {
        System.out.println("Cow " + getId() + " sent to " + slaughterhouse.getDescription());
    }

    public void saveToDatabase() {
        Document doc = new Document("id", getId())
                .append("breed", getBreed())
                .append("bornOn", getBornOn())
                .append("weight", getWeight())
                .append("isProducingMilk", isProducingMilk)
                .append("milkAmount", milkAmount);
        MongoConnection.saveDocument("cows", doc);
    }

    public boolean isProducingMilk() { return isProducingMilk; }
    public float getMilkAmount()     { return milkAmount; }
}
