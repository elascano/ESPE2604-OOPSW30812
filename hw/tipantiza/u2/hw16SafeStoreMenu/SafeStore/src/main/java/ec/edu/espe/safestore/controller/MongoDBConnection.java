
package ec.edu.espe.safestore.controller;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
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
    
    private static final String CONNECTION_STRING = "mongodb+srv://tipantizaalexander:Alexander20@cluster0.z86uqo3.mongodb.net/?appName=Cluster0";
    private static final String DATABASE_NAME = "SafeStoreGUI";
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