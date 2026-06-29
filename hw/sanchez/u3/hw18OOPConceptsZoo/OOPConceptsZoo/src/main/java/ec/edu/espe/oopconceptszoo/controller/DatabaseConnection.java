package ec.edu.espe.oopconceptszoo.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private MongoClient mongoClient;
    private MongoDatabase database;
    
    private static final String CONNECTION_STRING = "mongodb+srv://Joel:Joel@cluster0.aex8od4.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private static final String DATABASE_NAME = "OOPConceptsZoo";
    
    private DatabaseConnection() {
        try {
            mongoClient = MongoClients.create(CONNECTION_STRING);
            database = mongoClient.getDatabase(DATABASE_NAME);
            System.out.println("Connected to MongoDB Atlas");
        } catch (Exception e) {
            System.err.println("Error connecting to MongoDB Atlas: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    
    public MongoCollection<Document> getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }
    
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
    
    public boolean isConnected() {
        try {
            database.listCollectionNames().first();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}