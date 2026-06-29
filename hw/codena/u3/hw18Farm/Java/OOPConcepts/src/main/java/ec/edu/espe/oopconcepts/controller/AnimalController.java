package ec.edu.espe.oopconcepts.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import ec.edu.espe.oopconcepts.model.*;
import ec.edu.espe.oopconcepts.model.FarmAnimal;
import ec.edu.espe.oopconcepts.utils.MongoConnection;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import org.bson.Document;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class AnimalController {

    private MongoCollection<Document> collection;

    public AnimalController() {
        collection = MongoConnection.getDatabase().getCollection("animals");
    }

    public boolean create(FarmAnimal animal) {
        Document document = animal.toDocument();
        
        if (exists(animal.getId())) {
            return false;
        }

        collection.insertOne(animal.toDocument());
        
        return true;
    }

    public boolean update(FarmAnimal animal) {

        UpdateResult result = collection.replaceOne(Filters.eq("_id", animal.getId()), animal.toDocument());

        return result.getModifiedCount() > 0;
    }

    private FarmAnimal documentToAnimal(Document document) {

        int id = document.getInteger("_id");
        String type = document.getString("type");
        String breed = document.getString("breed");

        Date date = document.getDate("bornOnDate");
        LocalDate bornOnDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        float weight = document.getDouble("weight").floatValue();

        FarmAnimal animal;

        switch (type) {
            case "Chicken":

                boolean isMolting = document.getBoolean("isMolting");
                int numberOfEggs = document.getInteger("numberOfEggs");
                animal = new Chicken(id, breed, bornOnDate, weight, isMolting, numberOfEggs);
                break;

            case "Pig":

                float idealWeight = document.getDouble("idealWeight").floatValue();
                animal = new Pig(id, breed, bornOnDate, weight, idealWeight);
                break;

            case "Cow":

                boolean isProducingMilk = document.getBoolean("isProducingMilk");
                animal = new Cow(id, breed, bornOnDate, weight, isProducingMilk);
                break;

            case "Sheep":

                Date lastShearingDate = document.getDate("lastShearing");
                LocalDate lastShearing = lastShearingDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                animal = new Sheep(id, breed, bornOnDate, weight, lastShearing);
                break;

            default:
                throw new IllegalArgumentException("Unknown animal type: " + type);
        }

        return animal;

    }

    public ArrayList<FarmAnimal> read() {

        ArrayList<FarmAnimal> animals = new ArrayList<>();
        FindIterable<Document> documents = collection.find();
        for (Document doc : documents) {
            animals.add(documentToAnimal(doc));
        }

        return animals;
    }

    public boolean delete(int id) {

        DeleteResult result = collection.deleteOne(Filters.eq("_id", id));
        return result.getDeletedCount() > 0;

    }

    public FarmAnimal findById(int id) {

        Document document = collection.find(Filters.eq("_id", id)).first();
        FarmAnimal animal;
        animal = documentToAnimal(document);
        return animal;
    }

    public boolean exists(int id) {

        Document document = collection.find(Filters.eq("_id", id)).first();
        return document != null;
    }

}
