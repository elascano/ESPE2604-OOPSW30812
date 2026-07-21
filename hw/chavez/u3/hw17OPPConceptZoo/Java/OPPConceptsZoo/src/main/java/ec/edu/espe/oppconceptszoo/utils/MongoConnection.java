/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oppconceptszoo.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class MongoConnection {
     private static final String URI =
            "mongodb+srv://odalys:odalys@cluster0.2cf9puv.mongodb.net/?appName=Cluster0";

    private static final String DATABASE = "FarmDB";

    private static MongoDatabase database;

    private MongoConnection() {

    }

    public static MongoDatabase getDatabase() {

        if (database == null) {

            MongoClient client = MongoClients.create(URI);

            database = client.getDatabase(DATABASE);
        }

        return database;
    }
}
