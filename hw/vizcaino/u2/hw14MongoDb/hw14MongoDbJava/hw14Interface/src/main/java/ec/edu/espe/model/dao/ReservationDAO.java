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
import ec.edu.espe.model.MongoConnection;
import ec.edu.espe.model.Reservation;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

public class ReservationDAO {

    private final MongoCollection<Document> collection;

    public ReservationDAO() {

        MongoDatabase db =
                MongoConnection.getDatabase();

        collection =
                db.getCollection("reservations");
    }

    public void save(Reservation reservation) {

        Document doc = new Document();

        doc.append("id", reservation.getId());
        doc.append("customerName",
                reservation.getCustomerName());
        doc.append("phone",
                reservation.getPhone());
        doc.append("status",
                reservation.getStatus());

        collection.insertOne(doc);
    }

    public List<Reservation> findAll() {

        List<Reservation> reservations =
                new ArrayList<>();

        for (Document doc : collection.find()) {

            Reservation reservation =
                    new Reservation();

            reservation.setId(
                    doc.getInteger("id"));

            reservation.setCustomerName(
                    doc.getString("customerName"));

            reservation.setPhone(
                    doc.getString("phone"));

            reservation.setStatus(
                    doc.getString("status"));

            reservations.add(reservation);
        }

        return reservations;
    }

    public void delete(int id) {

        collection.deleteOne(
                new Document("id", id));
    }
}