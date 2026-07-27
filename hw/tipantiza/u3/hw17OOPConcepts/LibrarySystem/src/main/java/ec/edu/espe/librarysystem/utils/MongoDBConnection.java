
package ec.edu.espe.librarysystem.utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

public class MongoDBConnection {
    private static MongoDBConnection instance;
    private final MongoClient mongoClient;
    private final MongoDatabase database;
    private final Gson gson;
    private static final Logger logger = LoggerFactory.getLogger(MongoDBConnection.class);

    public static final String BOOKS_COLLECTION = "books";
    public static final String USERS_COLLECTION = "users";
    public static final String LOANS_COLLECTION = "loans";

    private static final String CONNECTION_STRING = "mongodb+srv://tipantizaalexander:Alexander20@cluster0.z86uqo3.mongodb.net/?appName=Cluster0";
    private static final String DATABASE_NAME = "library_db";

    private MongoDBConnection() {
        try {
            this.gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                    .create();
            
            this.mongoClient = MongoClients.create(CONNECTION_STRING);
            this.database = mongoClient.getDatabase(DATABASE_NAME);
            
            database.listCollectionNames().first();
            logger.info("Connected successfully to MongoDB: {}", DATABASE_NAME);
            
        } catch (Exception e) {
            logger.error("Error connecting to MongoDB", e);
            throw new RuntimeException("Failed to connect to MongoDB", e);
        }
    }

    public static synchronized MongoDBConnection getInstance() {
        if (instance == null) {
            instance = new MongoDBConnection();
        }
        return instance;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public MongoCollection<Document> getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }

    public <T> void insertDocument(String collectionName, T entity) {
        try {
            MongoCollection<Document> collection = getCollection(collectionName);
            String json = gson.toJson(entity);
            Document document = Document.parse(json);
            collection.insertOne(document);
            logger.debug("Document inserted in {}", collectionName);
        } catch (Exception e) {
            logger.error("Error inserting document", e);
            throw new RuntimeException("Error inserting document", e);
        }
    }

    public <T> List<T> findAllDocuments(String collectionName, Class<T> entityClass) {
        List<T> results = new ArrayList<>();
        try {
            MongoCollection<Document> collection = getCollection(collectionName);
            
            try (MongoCursor<Document> cursor = collection.find().iterator()) {
                while (cursor.hasNext()) {
                    Document document = cursor.next();
                    T entity = gson.fromJson(document.toJson(), entityClass);
                    results.add(entity);
                }
            }
            
            logger.debug("Retrieved {} documents from {}", results.size(), collectionName);
        } catch (Exception e) {
            logger.error("Error retrieving documents", e);
        }
        return results;
    }

    public <T> T findDocumentById(String collectionName, String id, Class<T> entityClass) {
        try {
            MongoCollection<Document> collection = getCollection(collectionName);
            Bson filter = Filters.eq("id", id);
            Document document = collection.find(filter).first();
            
            if (document != null) {
                return gson.fromJson(document.toJson(), entityClass);
            }
        } catch (Exception e) {
            logger.error("Error finding document by ID", e);
        }
        return null;
    }

    public <T> void updateDocument(String collectionName, String id, T entity) {
        try {
            MongoCollection<Document> collection = getCollection(collectionName);
            Bson filter = Filters.eq("id", id);
            String json = gson.toJson(entity);
            Document document = Document.parse(json);
            collection.replaceOne(filter, document);
            logger.debug("Document updated in {} with id: {}", collectionName, id);
        } catch (Exception e) {
            logger.error("Error updating document", e);
            throw new RuntimeException("Error updating document", e);
        }
    }

    public void deleteDocument(String collectionName, String id) {
        try {
            MongoCollection<Document> collection = getCollection(collectionName);
            Bson filter = Filters.eq("id", id);
            collection.deleteOne(filter);
            logger.debug("Document deleted from {} with id: {}", collectionName, id);
        } catch (Exception e) {
            logger.error("Error deleting document", e);
            throw new RuntimeException("Error deleting document", e);
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

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
            logger.info("MongoDB connection closed");
        }
    }
}
