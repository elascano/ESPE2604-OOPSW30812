/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.hw18farm.utlis;

import com.mongodb.client.*;
import org.bson.Document;

/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class MongoConnection {
    private static String URI = "mongodb+srv://cristian:Cristian@cris.djonnp4.mongodb.net/?appName=Cris";
    private static String DATABASE_NAME = "Farm";

    private static MongoDatabase database;

    public static MongoDatabase getDatabase() {

        try {

            if (database == null) {

                MongoClient client = MongoClients.create(URI);
                database = client.getDatabase(DATABASE_NAME);

                System.out.println("Connected to MongoDB");

            }

        } catch (Exception e) {
            System.out.println("Error connecting to MongoDB: " + e.getMessage());
        }

        return database;
    }
}
}
