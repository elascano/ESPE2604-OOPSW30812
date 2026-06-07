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
import ec.edu.espe.model.Backup;
import ec.edu.espe.model.MongoConnection;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class BackupDAO {

    private final MongoCollection<Document> collection;

    public BackupDAO() {

        MongoDatabase db =
                MongoConnection.getDatabase();

        collection =
                db.getCollection("backups");
    }

    public void save(Backup backup) {

        Document doc = new Document();

        doc.append("id", backup.getId());
        doc.append("fileName",
                backup.getFileName());
        doc.append("status",
                backup.getStatus());
        doc.append("date",
                backup.getDate());

        collection.insertOne(doc);
    }

    public List<Backup> findAll() {

        List<Backup> backups =
                new ArrayList<>();

        for(Document doc : collection.find()) {

            Backup backup =
                    new Backup();

            backup.setId(
                    doc.getInteger("id"));

            backup.setFileName(
                    doc.getString("fileName"));

            backup.setStatus(
                    doc.getString("status"));

            backup.setDate(
                    doc.getString("date"));

            backups.add(backup);
        }

        return backups;
    }

    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}