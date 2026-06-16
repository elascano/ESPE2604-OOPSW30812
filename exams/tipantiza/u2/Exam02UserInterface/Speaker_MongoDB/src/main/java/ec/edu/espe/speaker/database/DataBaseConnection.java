
package ec.edu.espe.speaker.database;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.speaker.model.Speaker;
import org.bson.Document;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
public class DataBaseConnection {
    
    private static final String CONNECTION_STRING = "mongodb+srv://tipantizaalexander:Alexander20@cluster0.z86uqo3.mongodb.net/?retryWrites=true&w=majority";
    private static final String DATABASE_NAME = "ACME_Products";
    private static final String COLLECTION_NAME = "Speakers";
    
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    
    public DataBaseConnection() {
        try {
            mongoClient = MongoClients.create(CONNECTION_STRING);
            database = mongoClient.getDatabase(DATABASE_NAME);
            collection = database.getCollection(COLLECTION_NAME);
            System.out.println("✓ Connected to MongoDB Atlas!");
        } catch (Exception e) {
            System.out.println("✗ MongoDB error: " + e.getMessage());
        }
    }
    
    public void saveSpeaker(Speaker speaker) {
        try {
            Document doc = new Document("id", speaker.getId())
                    .append("name", speaker.getName())
                    .append("description", speaker.getDescription())
                    .append("power", speaker.getPower())
                    .append("impedance", speaker.getImpedance())
                    .append("performance", speaker.calculatePerformance());
            
            collection.insertOne(doc);
            System.out.println("✓ Saved to MongoDB: " + speaker.getName());
        } catch (Exception e) {
            System.out.println("✗ Error saving: " + e.getMessage());
        }
    }
    
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}