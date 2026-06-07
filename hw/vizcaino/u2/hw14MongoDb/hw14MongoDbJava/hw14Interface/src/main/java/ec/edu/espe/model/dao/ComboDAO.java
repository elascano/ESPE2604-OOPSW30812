/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.model.dao;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.model.Combo;
import ec.edu.espe.model.MongoConnection;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class ComboDAO {

    private final MongoCollection<Document> collection;

    public ComboDAO() {

        MongoDatabase db =
                MongoConnection.getDatabase();

        collection =
                db.getCollection("combos");
    }

    public void save(Combo combo) {

        Document doc = new Document();

        doc.append("id", combo.getId());
        doc.append("name", combo.getName());
        doc.append("description",
                combo.getDescription());
        doc.append("price",
                combo.getPrice());

        collection.insertOne(doc);
    }

    public List<Combo> findAll() {

        List<Combo> combos =
                new ArrayList<>();

        for (Document doc : collection.find()) {

            Combo combo =
                    new Combo();

            combo.setId(
                    doc.getInteger("id"));

            combo.setName(
                    doc.getString("name"));

            combo.setDescription(
                    doc.getString("description"));

            combo.setPrice(
                    doc.getDouble("price"));

            combos.add(combo);
        }

        return combos;
    }

    public void delete(int id) {

        collection.deleteOne(
                new Document("id", id));
    }
}