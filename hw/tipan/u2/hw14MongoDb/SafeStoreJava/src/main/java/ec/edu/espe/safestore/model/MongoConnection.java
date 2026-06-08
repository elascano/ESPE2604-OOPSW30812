package ec.edu.espe.safestore.model;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

    private static final String URI =
        "mongodb+srv://Ronald:Ronald@cluster0.cd2ybxo.mongodb.net/?appName=Cluster0";

    private static MongoClient client;

    public static MongoDatabase getDatabase() {

        if (client == null) {
            client = MongoClients.create(URI);
        }

        return client.getDatabase("SafeStoreDB");
    }
}