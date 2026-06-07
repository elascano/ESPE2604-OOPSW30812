/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.model;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

    private static MongoDatabase database;

    static {

        String uri =
        "mongodb+srv://Adrian:Adrian@cluster0.e4n4vbs.mongodb.net/?appName=Cluster0";

        MongoClient client =
                MongoClients.create(uri);

        database =
                client.getDatabase("InventoryDB");
    }

    public static MongoDatabase getDatabase() {
        return database;
    }
}