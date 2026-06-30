package ec.edu.espe.farm.controller;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.farm.model.Food;
import org.bson.Document;
import utils.MongoConnection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Collahuazo Brandon, CodeBros, @ESPE
 */
public class FoodController {
    
    private final MongoCollection<Document> collection;

    public FoodController() {
        
        this.collection = MongoConnection.getCollection("Food");
    }

    public boolean saveFood(Food food) {
        try {
            Document doc = new Document("id", food.getId())
                    .append("description", food.getDescription())
                    .append("suitableFor", food.getSuitableFor());
            
            collection.insertOne(doc);
            return true;
        } catch (Exception e) {
            System.err.println("X Error saving food: " + e.getMessage());
            return false;
        }
    }
    public boolean deleteFood(int id) {
    try {
       
        Document query = new Document("id", id);
        collection.deleteOne(query);
        return true;
    } catch (Exception e) {
        System.err.println("X Error deleting food: " + e.getMessage());
        return false;
    }
}
   
    public List<Document> getAllFood() {
        List<Document> foods = new ArrayList<>();
        try {
            collection.find().into(foods);
        } catch (Exception e) {
            System.err.println("X Error retrieving food: " + e.getMessage());
        }
        return foods;
    }
}   