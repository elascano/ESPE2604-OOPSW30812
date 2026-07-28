package ec.edu.espe.strategypattern.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Alexander Tipantiza, CodeBreakers, @ESPE
 */

public class MongoDBConnection {
    // Usa una URI válida o crea una base de datos local para pruebas
    private static final String URI = "mongodb://localhost:27017"; // Cambia a tu URI local
    private static final String DB_NAME = "strategyTipantiza";
    private static final String COLLECTION_NAME = "arrayAlexander";
    private static MongoClient mongoClient;

    private MongoDBConnection() {}

    public static MongoDatabase getDatabase() {
        try {
            if (mongoClient == null) {
                mongoClient = MongoClients.create(URI);
                System.out.println("Conectado a MongoDB exitosamente");
            }
            return mongoClient.getDatabase(DB_NAME);
        } catch (Exception e) {
            System.err.println("Error al conectar a MongoDB: " + e.getMessage());
            return null;
        }
    }

    public static void insertRecord(Document document) {
        try {
            MongoDatabase db = getDatabase();
            if (db != null) {
                MongoCollection<Document> collection = db.getCollection(COLLECTION_NAME);
                collection.insertOne(document);
                System.out.println("Registro insertado exitosamente: " + document.toJson());
            } else {
                System.err.println("No se pudo obtener la base de datos, el registro no se guardó");
                // Mostrar el registro en consola como fallback
                System.out.println("Registro guardado localmente: " + document.toJson());
            }
        } catch (Exception e) {
            System.err.println("Error al insertar registro: " + e.getMessage());
            // Mostrar el registro en consola como fallback
            System.out.println("Registro guardado localmente: " + document.toJson());
        }
    }
}