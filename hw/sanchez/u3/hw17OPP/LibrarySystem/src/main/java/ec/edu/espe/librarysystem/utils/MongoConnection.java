package ec.edu.espe.librarysystem.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */

public class MongoConnection {

    private static final MongoClient client =
            MongoClients.create(
                    "mongodb+srv://Joel:Joel@cluster0.aex8od4.mongodb.net/?appName=Cluster0");

    private static final MongoDatabase database =
            client.getDatabase("libraryDB");

    public static MongoDatabase getDatabase() {
        return database;
    }
}
