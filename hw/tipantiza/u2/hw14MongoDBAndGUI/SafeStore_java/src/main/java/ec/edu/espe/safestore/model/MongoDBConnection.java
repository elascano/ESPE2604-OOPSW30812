package ec.edu.espe.safestore.model;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;

public class MongoDBConnection {
    
    private static final String CONNECTION_STRING = "mongodb+srv://tipantizaalexander:Alexander20@cluster0.z86uqo3.mongodb.net/?retryWrites=true&w=majority";
    private static final String DATABASE_NAME = "SafeStoreDB";
    
    private static MongoClient client;
    private static MongoDatabase database;
    private static boolean isConnected = false;
    
    public static void connect() {
        try {
            client = MongoClients.create(CONNECTION_STRING);
            database = client.getDatabase(DATABASE_NAME);
            isConnected = true;
            System.out.println("✅ Connected to MongoDB Atlas");
        } catch (Exception e) {
            System.err.println("❌ Connection failed: " + e.getMessage());
            isConnected = false;
        }
    }
    
    public static boolean isConnected() {
        return isConnected;
    }
    
    public static void close() {
        if (client != null) {
            client.close();
            isConnected = false;
        }
    }
    
    // ==================== SALES ====================
    
    private static MongoCollection<Document> getSalesCollection() {
        return database.getCollection("sales");
    }
    
    public static void saveSale(Document sale) {
        try {
            InsertOneResult result = getSalesCollection().insertOne(sale);
            System.out.println("✅ Sale saved: " + result.getInsertedId());
        } catch (Exception e) {
            System.err.println("❌ Error saving sale: " + e.getMessage());
        }
    }
    
    public static List<Document> getAllSales() {
    List<Document> sales = new ArrayList<>();
    try {
        System.out.println("Querying MongoDB for sales...");
        getSalesCollection().find().forEach(sales::add);
        System.out.println("Found " + sales.size() + " sales in database");
    } catch (Exception e) {
        System.err.println("Error loading sales: " + e.getMessage());
        e.printStackTrace();
    }
    return sales;
    }
    
    public static boolean deleteSale(String id) {
        try {
            DeleteResult result = getSalesCollection().deleteOne(new Document("_id", new ObjectId(id)));
            return result.getDeletedCount() > 0;
        } catch (Exception e) {
            return false;
        }
    }
    
    // ==================== PRODUCTS ====================
    
    private static MongoCollection<Document> getProductsCollection() {
        return database.getCollection("products");
    }
    
    public static void saveProduct(Document product) {
        try {
            InsertOneResult result = getProductsCollection().insertOne(product);
            System.out.println("✅ Product saved: " + result.getInsertedId());
        } catch (Exception e) {
            System.err.println("❌ Error saving product: " + e.getMessage());
        }
    }
    
    public static List<Document> getAllProducts() {
        List<Document> products = new ArrayList<>();
        try {
            getProductsCollection().find().forEach(products::add);
        } catch (Exception e) {
            System.err.println("❌ Error loading products: " + e.getMessage());
        }
        return products;
    }
    
    public static boolean updateProduct(String id, Document product) {
        try {
            UpdateResult result = getProductsCollection().updateOne(
                new Document("_id", new ObjectId(id)),
                new Document("$set", product)
            );
            return result.getModifiedCount() > 0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean deleteProduct(String id) {
        try {
            DeleteResult result = getProductsCollection().deleteOne(new Document("_id", new ObjectId(id)));
            return result.getDeletedCount() > 0;
        } catch (Exception e) {
            return false;
        }
    }
    
    // ==================== SUPPLIERS ====================
    
    private static MongoCollection<Document> getSuppliersCollection() {
        return database.getCollection("suppliers");
    }
    
    public static void saveSupplier(Document supplier) {
        try {
            InsertOneResult result = getSuppliersCollection().insertOne(supplier);
            System.out.println("✅ Supplier saved: " + result.getInsertedId());
        } catch (Exception e) {
            System.err.println("❌ Error saving supplier: " + e.getMessage());
        }
    }
    
    public static List<Document> getAllSuppliers() {
        List<Document> suppliers = new ArrayList<>();
        try {
            getSuppliersCollection().find().forEach(suppliers::add);
        } catch (Exception e) {
            System.err.println("❌ Error loading suppliers: " + e.getMessage());
        }
        return suppliers;
    }
    
    public static boolean updateSupplier(String id, Document supplier) {
        try {
            UpdateResult result = getSuppliersCollection().updateOne(
                new Document("_id", new ObjectId(id)),
                new Document("$set", supplier)
            );
            return result.getModifiedCount() > 0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean deleteSupplier(String id) {
        try {
            DeleteResult result = getSuppliersCollection().deleteOne(new Document("_id", new ObjectId(id)));
            return result.getDeletedCount() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}