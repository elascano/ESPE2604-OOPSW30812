package ec.edu.espe.parks.model;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Park {
    private String id;
    private String name;
    private double area;
    private int visitorCapacity;

    public Park() {
        this.id = "";
        this.name = "";
        this.area = 0.0;
        this.visitorCapacity = 0;
    }

  
    public double computeDensity() {
        if (visitorCapacity <= 0) {
            return 0.0;
        }
        return area / visitorCapacity;
    }

    
    public boolean saveToMongoDB() {
        
        String connectionString = "mongodb+srv://christopher:christopher123@christopher.i75hlaj.mongodb.net/";
        
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            
            MongoDatabase database = mongoClient.getDatabase("OOP_Quiz");
            
            MongoCollection<Document> collection = database.getCollection("Parks");

         
            Document doc = new Document("id", this.id)
                    .append("name", this.name)
                    .append("area", this.area)
                    .append("visitorCapacity", this.visitorCapacity)
                    .append("spacePerVisitor", this.computeDensity()); // Guarda el valor calculado

            
            collection.insertOne(doc);
            return true;
        } catch (Exception e) {
            System.err.println("Error al conectar o guardar en MongoDB: " + e.getMessage());
            return false;
        }
    }

    
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getArea() { return area; }
    public void setArea(double area) { this.area = area; }
    public int getVisitorCapacity() { return visitorCapacity; }
    public void setVisitorCapacity(int visitorCapacity) { this.visitorCapacity = visitorCapacity; }
}