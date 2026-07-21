/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.animalfarm.model;

import ec.edu.espe.animalfarm.controller.MongoConnection;
import java.util.Date;
import org.bson.Document;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class Sheep extends FarmAnimal{
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
