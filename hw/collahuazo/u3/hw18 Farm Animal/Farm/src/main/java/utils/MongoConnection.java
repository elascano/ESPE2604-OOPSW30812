package utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 * @author Collahuazo Brandon, CodeBros, @ESPE
 */
public class MongoConnection {
    private static final String CONNECTION_STRING = "mongodb+srv://brandon:Pepe123@cluster0.evr08tq.mongodb.net/?appName=Cluster0";
    private static final String DATABASE_NAME = "FarmSystem";
    
    private static MongoClient mongoClient = null;
    private static MongoDatabase database = null;

    private MongoConnection() {}

    public static MongoDatabase getDatabase() {
        if (database == null) {
            try {
                mongoClient = MongoClients.create(CONNECTION_STRING);
                database = mongoClient.getDatabase(DATABASE_NAME);
                System.out.println("--> Successfully connected to MongoDB Atlas: " + DATABASE_NAME);
            } catch (Exception e) {
                System.err.println("X Error connecting to MongoDB: " + e.getMessage());
            }
        }
        return database;
    }

    public static MongoCollection<Document> getCollection(String collectionName) {
        return getDatabase().getCollection(collectionName);
    }

    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("--> MongoDB connection closed.");
        }
    }
}