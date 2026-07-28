
package ec.edu.espe.strategypattern.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Alexander Tipantiza, CodeBreakers, @ESPE
 */

public class MongoDBConnection {
    private static final String CONNECTION_URI = "mongodb+srv://tipantizaalexander:Alexander20@cluster0.z86uqo3.mongodb.net/?appName=Cluster0";
    private static final String DATABASE_NAME = "strategyTipantiza";
    private static final String COLLECTION_NAME = "arrayAlexander";
    
    private static MongoClient mongoClient = null;

    private MongoDBConnection() {}

    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(CONNECTION_URI);
        }
        return mongoClient.getDatabase(DATABASE_NAME);
    }

    public static void insertRecord(Document document) {
        try {
            MongoCollection<Document> collection = getDatabase().getCollection(COLLECTION_NAME);
            collection.insertOne(document);
        } catch (Exception e) {
            mongoClient = MongoClients.create(CONNECTION_URI);
            MongoCollection<Document> collection = mongoClient.getDatabase(DATABASE_NAME).getCollection(COLLECTION_NAME);
            collection.insertOne(document);
        }
    }
}