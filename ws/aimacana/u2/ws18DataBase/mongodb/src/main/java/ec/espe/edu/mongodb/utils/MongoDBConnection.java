package ec.espe.edu.mongodb.utils;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.concurrent.TimeUnit;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * Singleton database connection manager for MongoDB.
 * 
 * @author Anthony Aimacaña, MKA programmer, @ESPE
 */
public class MongoDBConnection {
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    
    // User requested credentials: user "mongodb", password "mongodb", database "mongodb"
    private static final String CONNECTION_STRING = "mongodb://mongodb:mongodb@157.137.223.54:27017/mongodb?authSource=mongodb";
    private static final String DATABASE_NAME = "mongodb";

    private MongoDBConnection() {}

    public static synchronized MongoDatabase getDatabase() {
        if (database == null) {
            CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build())
            );

            MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(CONNECTION_STRING))
                .codecRegistry(pojoCodecRegistry)
                .applyToClusterSettings(builder -> 
                    builder.serverSelectionTimeout(3000, TimeUnit.MILLISECONDS)
                )
                .build();

            mongoClient = MongoClients.create(settings);
            database = mongoClient.getDatabase(DATABASE_NAME);
        }
        return database;
    }

    public static synchronized void close() {
        if (mongoClient != null) {
            try {
                mongoClient.close();
            } catch (Exception ignored) {}
            mongoClient = null;
            database = null;
        }
    }
}
