/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.Strategy.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import ec.edu.espe.Strategy.model.SortingRecord;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class MongoDBConnection {
    private static final String CONNECTION_URI = "mongodb+srv://cristian:Cristian@cris.djonnp4.mongodb.net/?appName=Cris";
    private static final String DATABASE_NAME = "strategy";
    private static final String COLLECTION_NAME = "array    ";

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
            getCollection().insertOne(record.toDocument());
            return true;
        } catch (Exception e) {
            System.err.println("Error saving record to MongoDB: " + e.getMessage());
            return false;
        }
    }

    public static List<SortingRecord> getAllRecords() {
        List<SortingRecord> records = new ArrayList<>();
        try {
            getCollection().find()
                    .map(SortingRecord::fromDocument)
                    .into(records);
        } catch (Exception e) {
            System.err.println("Error fetching records from MongoDB: " + e.getMessage());
        }
        return records;
    }
}
