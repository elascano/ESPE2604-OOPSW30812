/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.safestore.controller;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.concurrent.TimeUnit;

public class MongoDBConnection {
    
    private static final String CONNECTION_STRING = "mongodb+srv://Joel:Joel@cluster0.aex8od4.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private static final String DATABASE_NAME = "safestore";
    private MongoClient mongoClient;
    private MongoDatabase database;
    
    public boolean connect() {
        try {
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(CONNECTION_STRING))
                    .applyToSocketSettings(builder -> builder.connectTimeout(30, TimeUnit.SECONDS))
                    .build();
            
            mongoClient = MongoClients.create(settings);
            database = mongoClient.getDatabase(DATABASE_NAME);
            database.runCommand(new Document("ping", 1));
            System.out.println("Connected to MongoDB Atlas");
            return true;
        } catch (Exception e) {
            System.out.println("Error connecting to MongoDB: " + e.getMessage());
            return false;
        }
    }
    
    public MongoDatabase getDatabase() {
        return database;
    }
    
    public MongoCollection<Document> getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }
    
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Connection closed");
        }
    }
    
    public boolean isConnected() {
        return mongoClient != null && database != null;
    }
}