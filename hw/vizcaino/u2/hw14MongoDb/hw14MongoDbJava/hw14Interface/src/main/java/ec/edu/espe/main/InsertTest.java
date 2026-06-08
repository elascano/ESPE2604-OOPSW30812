/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.main;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
import com.mongodb.client.MongoCollection;
import ec.edu.espe.model.MongoConnection;
import org.bson.Document;

public class InsertTest {

    public static void main(String[] args) {

        MongoCollection<Document> collection =
                MongoConnection.getDatabase()
                        .getCollection("backups");

        Document doc = new Document();

        doc.append("id", 1);
        doc.append("fileName", "First Backup");
        doc.append("status", "Active");
        doc.append("date", "2026-06-05");

        collection.insertOne(doc);

        System.out.println("Inserted successfully");

    }
}
