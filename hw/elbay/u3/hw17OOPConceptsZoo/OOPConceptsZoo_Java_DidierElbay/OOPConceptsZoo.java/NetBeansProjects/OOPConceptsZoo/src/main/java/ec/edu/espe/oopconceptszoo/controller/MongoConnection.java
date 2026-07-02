package ec.edu.espe.oopconceptszoo.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Singleton connection manager for MongoDB Atlas.
 * Replace CONNECTION_STRING with your own MongoDB Atlas URI.
 *
 * @author Didier Elbay
 */
public class MongoConnection {

    private static MongoClient mongoClient;
    private static MongoDatabase database;

    // Replace with your own MongoDB Atlas connection string
    private static final String CONNECTION_STRING =
            "mongodb+srv://YOUR_USER:YOUR_PASSWORD@YOUR_CLUSTER.mongodb.net/?appName=FarmZoo";
    private static final String DATABASE_NAME = "FarmZooDB";

    public static MongoDatabase getDatabase() {
        if (database == null) {
            try {
                mongoClient = MongoClients.create(CONNECTION_STRING);
                database = mongoClient.getDatabase(DATABASE_NAME);
            } catch (Exception e) {
                System.err.println("Error connecting to MongoDB Atlas: " + e.getMessage());
            }
        }
        return database;
    }

    public static void saveDocument(String collectionName, Document document) {
        try {
            MongoDatabase db = getDatabase();
            if (db != null) {
                db.getCollection(collectionName).insertOne(document);
            }
        } catch (Exception e) {
            System.err.println("Error saving document to " + collectionName + ": " + e.getMessage());
        }
    }
}
