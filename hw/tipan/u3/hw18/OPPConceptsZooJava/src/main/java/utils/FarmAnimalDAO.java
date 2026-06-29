package utils;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.ArrayList;

public class FarmAnimalDAO {

    private MongoCollection<Document> collection;

    public FarmAnimalDAO() {
        MongoDatabase database = MongoManager.getDatabase();
        collection = database.getCollection("animals");
    }

    public void saveAnimal(int id, String breed, float weight, String type) {

        Document animal = new Document("id", id)
                .append("breed", breed)
                .append("weight", weight)
                .append("type", type);

        collection.insertOne(animal);

        System.out.println("Animal saved successfully.");
    }

    public ArrayList<String> getAnimals() {

        ArrayList<String> animals = new ArrayList<>();

        for (Document document : collection.find()) {

            String animal =
                    "ID: " + document.getInteger("id")
                    + " | Breed: " + document.getString("breed")
                    + " | Weight: " + document.get("weight")
                    + " | Type: " + document.getString("type");

            animals.add(animal);
        }

        return animals;
    }

}