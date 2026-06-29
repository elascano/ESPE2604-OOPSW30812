package ec.edu.espe.oopconcepts.utils;

import com.mongodb.client.*;
import org.bson.Document;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
public class MongoConnection {

    private static String URI = "mongodb+srv://tipantizaalexander:Alexander20@cluster0.z86uqo3.mongodb.net/?appName=Cluster0";
    private static String DATABASE_NAME = "FarmChickenSystem";

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
