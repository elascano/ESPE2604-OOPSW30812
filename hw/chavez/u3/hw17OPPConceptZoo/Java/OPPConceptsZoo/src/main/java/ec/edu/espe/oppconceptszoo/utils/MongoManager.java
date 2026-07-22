/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oppconceptszoo.utils;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class MongoManager {
    private final MongoCollection<Document> collection;

    public MongoManager() {

        MongoDatabase database = MongoConnection.getDatabase();

        collection = database.getCollection("animals");
    }

    public void saveAnimal(Document animal) {

        collection.insertOne(animal);

        System.out.println("Animal saved successfully");
    }

    
    
}
