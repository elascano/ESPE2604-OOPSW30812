package ec.edu.espe.farm.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import ec.edu.espe.farm.model.Cut;
import java.util.ArrayList;
import org.bson.Document;
import utils.MongoConnection;

/**
 * @author Collahuazo Brandon, CodeBros, @ESPE
 */
public class CutController {
    private final MongoCollection<Document> collection;

    public CutController() {
      
        this.collection = MongoConnection.getCollection("Cut");
    }

 
    public boolean saveCut(int animalId, int id, String description, String procedure, float weight) {
    try {
      
        Document doc = new Document("animalId", animalId)
                .append("id", id)
                .append("description", description)
                .append("procedure", procedure)
                .append("weight", weight);
        
        collection.insertOne(doc);
        return true;
    } catch (Exception e) {
        System.err.println("X Error saving cut: " + e.getMessage());
        return false;
    }
}

   public ArrayList<Cut> getCutsByAnimal(int animalId) {
    ArrayList<Cut> cutsList = new ArrayList<>();
    try {
       
        Document query = new Document("animalId", animalId);
        FindIterable<Document> documents = collection.find(query);
        
        for (Document doc : documents) {
            Cut cut = new Cut(
                doc.getInteger("id"),
                doc.getString("description"),
                doc.getString("procedure"),
                doc.getDouble("weight").floatValue()
            );
            cutsList.add(cut);
        }
    } catch (Exception e) {
        System.err.println("X Error retrieving cuts: " + e.getMessage());
    }
    return cutsList;
}
    public boolean deleteCut(int id) {
        try {
            Document query = new Document("id", id);
            collection.deleteOne(query);
            return true;
        } catch (Exception e) {
            System.err.println("X Error deleting cut: " + e.getMessage());
            return false;
        }
    }
}