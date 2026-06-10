package Utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    private static final String URI = "mongodb+srv://brandon:1752221067@cluster0.evr08tq.mongodb.net/?appName=Cluster0";
    private static final String DATABASE_NAME = "inventoryHub";

    public static MongoDatabase getDatabase() {
        MongoClient mongoClient = MongoClients.create(URI);
        return mongoClient.getDatabase(DATABASE_NAME);
    }
}