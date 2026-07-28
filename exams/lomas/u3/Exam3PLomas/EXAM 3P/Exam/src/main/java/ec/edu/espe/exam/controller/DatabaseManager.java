package ec.edu.espe.exam.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.exam.model.NumberArray;
import org.bson.Document;

public class DatabaseManager {
    private static final String URI = "mongodb+srv://christopher:christopher171206@christopher.i75hlaj.mongodb.net/?appName=christopher";
    private static final String DB_NAME = "strategyLomas";
    private static final String COLLECTION_NAME = "arrayChristopher";

    public static void save(NumberArray numberArray) {
        try (MongoClient mongoClient = MongoClients.create(URI)) {
            MongoDatabase database = mongoClient.getDatabase(DB_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            Document doc = new Document("unsorted", numberArray.getUnsorted())
                    .append("size", numberArray.getSize())
                    .append("algorithm", numberArray.getAlgorithm())
                    .append("sorted", numberArray.getSorted());

            collection.insertOne(doc);
        }
    }
}