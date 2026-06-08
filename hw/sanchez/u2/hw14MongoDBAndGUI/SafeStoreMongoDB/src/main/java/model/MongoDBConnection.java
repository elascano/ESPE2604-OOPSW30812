/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import config.DatabaseConfig;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */

public class MongoDBConnection {
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    
    public static void connect() {
        try {
            mongoClient = MongoClients.create(DatabaseConfig.CONNECTION_STRING);
            database = mongoClient.getDatabase(DatabaseConfig.DATABASE_NAME);
            System.out.println("Connected to MongoDB Atlas");
        } catch (Exception e) {
            System.err.println("Error connecting to MongoDB: " + e.getMessage());
        }
    }
    
    public static MongoDatabase getDatabase() {
        if (database == null) {
            connect();
        }
        return database;
    }
    
    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Disconnected from MongoDB");
        }
    }
    
    public static List<Document> getAllProductsFromCloud() {
        List<Document> products = new ArrayList<>();
        try {
            MongoCollection<Document> collection = getDatabase().getCollection(DatabaseConfig.PRODUCTS_COLLECTION);
            collection.find().forEach(products::add);
        } catch (Exception e) {
            System.err.println("Error getting products: " + e.getMessage());
        }
        return products;
    }
    
    public static void uploadProductToCloud(Document product) {
        try {
            MongoCollection<Document> collection = getDatabase().getCollection(DatabaseConfig.PRODUCTS_COLLECTION);
            collection.insertOne(product);
            System.out.println("Product uploaded to cloud");
        } catch (Exception e) {
            System.err.println("Error uploading product: " + e.getMessage());
        }
    }
    
    public static void updateProductInCloud(int id, Document updates) {
        try {
            MongoCollection<Document> collection = getDatabase().getCollection(DatabaseConfig.PRODUCTS_COLLECTION);
            collection.updateOne(Filters.eq("id", id), new Document("$set", updates));
            System.out.println("Product updated in cloud");
        } catch (Exception e) {
            System.err.println("Error updating product: " + e.getMessage());
        }
    }
    
    public static void deleteProductFromCloud(int id) {
        try {
            MongoCollection<Document> collection = getDatabase().getCollection(DatabaseConfig.PRODUCTS_COLLECTION);
            collection.deleteOne(Filters.eq("id", id));
            System.out.println("Product deleted from cloud");
        } catch (Exception e) {
            System.err.println("Error deleting product: " + e.getMessage());
        }
    }
    
    public static List<Document> getAllCreditsFromCloud() {
        List<Document> credits = new ArrayList<>();
        try {
            MongoCollection<Document> collection = getDatabase().getCollection(DatabaseConfig.CREDITS_COLLECTION);
            collection.find().forEach(credits::add);
        } catch (Exception e) {
            System.err.println("Error getting credits: " + e.getMessage());
        }
        return credits;
    }
    
    public static void uploadCreditToCloud(Document credit) {
        try {
            MongoCollection<Document> collection = getDatabase().getCollection(DatabaseConfig.CREDITS_COLLECTION);
            collection.insertOne(credit);
            System.out.println("Credit uploaded to cloud");
        } catch (Exception e) {
            System.err.println("Error uploading credit: " + e.getMessage());
        }
    }
    
    public static void updateCreditInCloud(int customerId, Document updates) {
        try {
            MongoCollection<Document> collection = getDatabase().getCollection(DatabaseConfig.CREDITS_COLLECTION);
            collection.updateOne(Filters.eq("customerId", customerId), new Document("$set", updates));
            System.out.println("Credit updated in cloud");
        } catch (Exception e) {
            System.err.println("Error updating credit: " + e.getMessage());
        }
    }
    
    public static void deleteCreditFromCloud(int customerId) {
        try {
            MongoCollection<Document> collection = getDatabase().getCollection(DatabaseConfig.CREDITS_COLLECTION);
            collection.deleteOne(Filters.eq("customerId", customerId));
            System.out.println("Credit deleted from cloud");
        } catch (Exception e) {
            System.err.println("Error deleting credit: " + e.getMessage());
        }
    }
    
    public static void syncFromCloudToLocal() {
        List<Document> cloudProducts = getAllProductsFromCloud();
        for (Document doc : cloudProducts) {
            int id = doc.getInteger("id");
            String name = doc.getString("name");
            double wholesalePrice = doc.getDouble("wholesalePrice");
            double retailPrice = doc.getDouble("retailPrice");
            int stock = doc.getInteger("stock");
            int minStock = doc.getInteger("minStock");
            String expiryDate = doc.getString("expiryDate");
            
            ProductManagement.Product existing = ProductManagement.findById(id);
            if (existing == null) {
                ProductManagement.Product newProduct = new ProductManagement.Product(id, name, wholesalePrice, retailPrice, stock, minStock, expiryDate);
                ProductManagement.addProduct(newProduct);
            } else {
                existing.setName(name);
                existing.setWholesalePrice(wholesalePrice);
                existing.setRetailPrice(retailPrice);
                existing.setStock(stock);
                existing.setMinStock(minStock);
                existing.setExpiryDate(expiryDate);
                ProductManagement.saveToFile();
            }
        }
        
        List<Document> cloudCredits = getAllCreditsFromCloud();
        for (Document doc : cloudCredits) {
            int customerId = doc.getInteger("customerId");
            String customerName = doc.getString("customerName");
            double creditLimit = doc.getDouble("creditLimit");
            double currentDebt = doc.getDouble("currentDebt");
            boolean isBlocked = doc.getBoolean("isBlocked");
            
            CreditManagement.CreditAccount existing = CreditManagement.findAccountById(customerId);
            if (existing == null) {
                CreditManagement.CreditAccount newCredit = new CreditManagement.CreditAccount(customerId, customerName, creditLimit);
                newCredit.setCurrentDebt(currentDebt);
                newCredit.setBlocked(isBlocked);
                CreditManagement.createAccount(newCredit);
            } else {
                existing.setCustomerName(customerName);
                existing.setCreditLimit(creditLimit);
                existing.setCurrentDebt(currentDebt);
                existing.setBlocked(isBlocked);
                CreditManagement.saveToFile();
            }
        }
        
        System.out.println("Sync completed: CLOUD → LOCAL");
    }
    
    public static void syncFromLocalToCloud() {
        List<ProductManagement.Product> localProducts = ProductManagement.getAllProducts();
        for (ProductManagement.Product p : localProducts) {
            Document doc = new Document()
                    .append("id", p.getId())
                    .append("name", p.getName())
                    .append("wholesalePrice", p.getWholesalePrice())
                    .append("retailPrice", p.getRetailPrice())
                    .append("stock", p.getStock())
                    .append("minStock", p.getMinStock())
                    .append("expiryDate", p.getExpiryDate());
            
            MongoCollection<Document> collection = getDatabase().getCollection(DatabaseConfig.PRODUCTS_COLLECTION);
            collection.updateOne(
                    Filters.eq("id", p.getId()),
                    new Document("$set", doc),
                    new UpdateOptions().upsert(true)
            );
        }
        
        List<CreditManagement.CreditAccount> localCredits = CreditManagement.getAllAccounts();
        for (CreditManagement.CreditAccount c : localCredits) {
            Document doc = new Document()
                    .append("customerId", c.getCustomerId())
                    .append("customerName", c.getCustomerName())
                    .append("creditLimit", c.getCreditLimit())
                    .append("currentDebt", c.getCurrentDebt())
                    .append("isBlocked", c.isBlocked());
            
            MongoCollection<Document> collection = getDatabase().getCollection(DatabaseConfig.CREDITS_COLLECTION);
            collection.updateOne(
                    Filters.eq("customerId", c.getCustomerId()),
                    new Document("$set", doc),
                    new UpdateOptions().upsert(true)
            );
        }
        
        System.out.println("Sync completed: LOCAL → CLOUD");
    }
}
