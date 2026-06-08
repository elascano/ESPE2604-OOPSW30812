/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mothersApp.model;

/**
 *
 * @author Cristian
 */
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MotherRepository {

    private MongoCollection<Document> collection;

    public MotherRepository() {
        MongoDatabase db = MongoDBConnection.getDatabase();
        this.collection = db.getCollection("mothers");
    }

    public void save(Mother mother) {
        Document doc = new Document()
            .append("firstName", mother.firstName)
            .append("lastName", mother.lastName)
            .append("id", mother.id)
            .append("birthDate", mother.birthDate);
        collection.insertOne(doc);
        System.out.println("Mother saved to MongoDB!");
    }

    public void listAll() {
        System.out.println("\n--- Mothers in DB ---");
        for (Document doc : collection.find()) {
            System.out.println("-> " + doc.getString("firstName") 
                + " " + doc.getString("lastName") 
                + " | ID: " + doc.getString("id"));
        }
    }
}