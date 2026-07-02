package ec.edu.espe.oopconceptszoo.model;

import ec.edu.espe.oopconceptszoo.controller.MongoConnection;
import java.util.Date;
import org.bson.Document;

/**
 * Represents a chicken in the farm.
 *
 * @author Didier Elbay
 */
public class Chicken extends FarmAnimal {

    private boolean isMolting;
    private int numberOfEggsPerWeek;

    public Chicken(int id, String breed, Date bornOn, float weight,
                   boolean isMolting, int numberOfEggsPerWeek) {
        super(id, breed, bornOn, weight);
        this.isMolting = isMolting;
        this.numberOfEggsPerWeek = numberOfEggsPerWeek;
    }

    public void layAnEgg() {
        System.out.println("Chicken " + getId() + " laid an egg.");
    }

    /**
     * Saves this chicken's record to the database.
     */
    public void saveToDatabase() {
        Document doc = new Document("id", getId())
                .append("breed", getBreed())
                .append("bornOn", getBornOn())
                .append("weight", getWeight())
                .append("isMolting", isMolting)
                .append("numberOfEggsPerWeek", numberOfEggsPerWeek);
        MongoConnection.saveDocument("chickens", doc);
    }

    public boolean isMolting()            { return isMolting; }
    public int getNumberOfEggsPerWeek()   { return numberOfEggsPerWeek; }
}
