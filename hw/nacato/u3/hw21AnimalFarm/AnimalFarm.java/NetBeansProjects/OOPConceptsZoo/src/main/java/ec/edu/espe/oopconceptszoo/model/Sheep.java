package ec.edu.espe.oopconceptszoo.model;

import ec.edu.espe.oopconceptszoo.controller.MongoConnection;
import java.util.Date;
import org.bson.Document;

public class Sheep extends FarmAnimal {
    Date lastSheering;

    public Sheep(int id, String breed, Date bornOn, float weight, Date lastSheering) {
        super(id, breed, bornOn, weight);
        this.lastSheering = lastSheering;
    }

    public void saveToDatabase() {
        Document doc = new Document("id", getId())
                .append("breed", getBreed())
                .append("bornOn", getBornOn())
                .append("weight", getWeight())
                .append("lastSheering", lastSheering);
        MongoConnection.saveDocument("sheeps", doc);
    }

    public Date getLastSheering() { return lastSheering; }
}