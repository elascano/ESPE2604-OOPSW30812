/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mongo;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
import com.mongodb.client.*;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class MongoDBConnection {

    private MongoClient client;
    private MongoDatabase db;
    private MongoCollection<Document> collection;

    public MongoDBConnection() {

        String uri = "mongodb+srv://Adrian:Adrian@cluster0.e4n4vbs.mongodb.net/?appName=Cluster0";

        client = MongoClients.create(uri);
        db = client.getDatabase("hw17Java");
        collection = db.getCollection("users");
    }

    public void insertUser(String name, String plan) {
        collection.insertOne(new Document("name", name).append("plan", plan));
    }

    public List<Document> getAllUsers() {

        List<Document> list = new ArrayList<>();

        for (Document d : collection.find()) {
            list.add(d);
        }

        return list;
    }

    public void updateUser(String name, String plan) {
        collection.updateOne(
                new Document("name", name),
                new Document("$set", new Document("plan", plan))
        );
    }

    public void deleteUser(String name) {
        collection.deleteOne(new Document("name", name));
    }
}