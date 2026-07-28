package ec.edu.espe.oopconceptszoo.model;

import ec.edu.espe.oopconceptszoo.controller.MongoConnection;
import java.util.Date;
import org.bson.Document;

public class Chicken extends FarmAnimal {
    boolean isMolting;
    int numberOfEggsPerWeek;

    public Chicken(int id, String breed, Date bornOn, float weight, boolean isMolting, int numberOfEggsPerWeek) {
        super(id, breed, bornOn, weight);
        this.isMolting = isMolting;
        this.numberOfEggsPerWeek = numberOfEggsPerWeek;
    }

    public void layAnEgg() {
        System.out.println("Egg laid.");
    }

    public void saveToDatabase() {
        Document doc = new Document("id", getId())
                .append("breed", getBreed())
                .append("bornOn", getBornOn())
                .append("weight", getWeight())
                .append("isMolting", isMolting)
                .append("numberOfEggsPerWeek", numberOfEggsPerWeek);
        MongoConnection.saveDocument("chickens", doc);
    }

    public boolean isMolting() { return isMolting; }
    public int getNumberOfEggsPerWeek() { return numberOfEggsPerWeek; }
}