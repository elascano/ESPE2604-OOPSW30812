package ec.edu.espe.oopconceptszoo.model;

import ec.edu.espe.oopconceptszoo.controller.IMeatAnimal;
import ec.edu.espe.oopconceptszoo.controller.MongoConnection;
import java.util.ArrayList;
import java.util.Date;
import org.bson.Document;

/**
 * Represents a pig in the farm. Implements IMeatAnimal.
 *
 * @author Didier Elbay
 */
public class Pig extends FarmAnimal implements IMeatAnimal {

    private float idealWeight;

    public Pig(int id, String breed, Date bornOn, float weight, float idealWeight) {
        super(id, breed, bornOn, weight);
        this.idealWeight = idealWeight;
    }

    /**
     * Returns true if the pig has reached its ideal slaughter weight.
     */
    public boolean isReadyForSlaughter() {
        return getWeight() >= idealWeight;
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts = new ArrayList<>();
        cuts.add(new Cut(1, "Pork Chop", "Standard Cut",   getWeight() * 0.15f));
        cuts.add(new Cut(2, "Ribs",      "Rib Extraction", getWeight() * 0.10f));
        return cuts;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterhouse) {
        System.out.println("Pig " + getId() + " sent to " + slaughterhouse.getDescription());
    }

    public void saveToDatabase() {
        Document doc = new Document("id", getId())
                .append("breed", getBreed())
                .append("bornOn", getBornOn())
                .append("weight", getWeight())
                .append("idealWeight", idealWeight);
        MongoConnection.saveDocument("pigs", doc);
    }

    public float getIdealWeight() { return idealWeight; }
}
