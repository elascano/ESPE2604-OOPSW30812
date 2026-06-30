package ec.edu.espe.oopconceptszoo.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    private MongoDBConnection() {}

    public static MongoDatabase getDatabase() {
        if (database == null) {
            String uri = "mongodb://admin:AZaxnebula18*@157.137.223.54:27017/admin"; // Change if needed
            mongoClient = MongoClients.create(uri);
            database = mongoClient.getDatabase("ZooDB");
        }
        return database;
    }
}
