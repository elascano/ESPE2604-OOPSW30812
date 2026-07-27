package ec.edu.espe.strategy.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.strategy.model.SortingRecord;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoDBConnection {
    private static final String CONNECTION_URI = "mongodb://mateo0020:mateo2026@157.137.223.54:27017/admin";
    private static final String DATABASE_NAME = "strategyArtieda";
    private static final String COLLECTION_NAME = "arrayMateo";

    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public static synchronized MongoDatabase getDatabase() {
        if (database == null) {
            try {
                mongoClient = MongoClients.create(CONNECTION_URI);
                database = mongoClient.getDatabase(DATABASE_NAME);
            } catch (Exception e) {
                System.err.println("Error connecting to MongoDB: " + e.getMessage());
                throw e;
            }
        }
        return database;
    }

    public static MongoCollection<Document> getCollection() {
        return getDatabase().getCollection(COLLECTION_NAME);
    }

    public static boolean saveSortingRecord(SortingRecord record) {
        try {
            MongoCollection<Document> collection = getCollection();
            collection.insertOne(record.toDocument());
            return true;
        } catch (Exception e) {
            System.err.println("Error saving record to MongoDB: " + e.getMessage());
            return false;
        }
    }

    public static List<SortingRecord> getAllRecords() {
        List<SortingRecord> records = new ArrayList<>();
        try {
            MongoCollection<Document> collection = getCollection();
            for (Document doc : collection.find()) {
                records.add(SortingRecord.fromDocument(doc));
            }
        } catch (Exception e) {
            System.err.println("Error fetching records from MongoDB: " + e.getMessage());
        }
        return records;
    }
}
