package ec.edu.espe.oopconceptszoo.model;

import ec.edu.espe.oopconceptszoo.controller.MongoConnection;
import java.util.Date;
import org.bson.Document;

/**
 * Represents a sheep in the farm.
 *
 * @author Didier Elbay
 */
public class Sheep extends FarmAnimal {

    private Date lastSheering;

    public Sheep(int id, String breed, Date bornOn, float weight, Date lastSheering) {
        super(id, breed, bornOn, weight);
        this.lastSheering = lastSheering;
    }

    /**
     * Performs a shearing and updates the lastSheering date to today.
     */
    public void shear() {
        this.lastSheering = new Date();
        System.out.println("Sheep " + getId() + " has been sheared on " + lastSheering);
    }

    /**
     * Returns true if the sheep is within the optimal weight range for shearing.
     */
    public boolean isReadyForShearing() {
        return getWeight() >= 45.0f && getWeight() <= 80.0f;
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
