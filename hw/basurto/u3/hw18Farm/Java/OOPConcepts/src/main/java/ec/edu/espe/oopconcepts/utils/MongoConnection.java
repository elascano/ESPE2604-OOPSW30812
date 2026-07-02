package ec.edu.espe.oopconcepts.utils;

import com.mongodb.client.*;
import org.bson.Document;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class MongoConnection {

    private static String URI = "mongodb+srv://daniel:daniel1234@cluster0.zfwd5wx.mongodb.net/?appName=Cluster0";
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
