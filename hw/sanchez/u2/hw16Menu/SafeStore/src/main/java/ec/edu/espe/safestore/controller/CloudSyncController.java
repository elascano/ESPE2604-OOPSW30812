/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.safestore.controller;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */

import com.mongodb.client.MongoCollection;
import ec.edu.espe.safestore.model.Product;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class CloudSyncController {
    
    private MongoDBConnection dbConnection;
    private ProductController productController;
    
    public CloudSyncController() {
        dbConnection = new MongoDBConnection();
        productController = new ProductController();
    }
    
    public boolean connect() {
        return dbConnection.connect();
    }
    
    public void disconnect() {
        dbConnection.close();
    }
    
    public boolean isConnected() {
        return dbConnection.isConnected();
    }
    
    public void uploadProducts() {
        List<Product> products = productController.getAllProducts();
        MongoCollection<Document> collection = dbConnection.getCollection("products");
        collection.deleteMany(new Document());
        
        for (Product p : products) {
            Document doc = new Document("id", p.getId())
                    .append("name", p.getName())
                    .append("wholesalePrice", p.getWholesalePrice())
                    .append("retailPrice", p.getRetailPrice())
                    .append("stock", p.getStock())
                    .append("minStock", p.getMinStock())
                    .append("expiryDate", p.getExpiryDate());
            collection.insertOne(doc);
        }
        System.out.println("Products uploaded: " + products.size());
    }
    
    public void downloadProducts() {
        MongoCollection<Document> collection = dbConnection.getCollection("products");
        List<Product> products = new ArrayList<>();
        
        for (Document doc : collection.find()) {
            Integer id = doc.getInteger("id");
            if (id == null) continue;
            
            Product p = new Product(
                    id,
                    doc.getString("name") != null ? doc.getString("name") : "No name",
                    doc.getDouble("wholesalePrice") != null ? doc.getDouble("wholesalePrice") : 0.0,
                    doc.getDouble("retailPrice") != null ? doc.getDouble("retailPrice") : 0.0,
                    doc.getInteger("stock") != null ? doc.getInteger("stock") : 0,
                    doc.getInteger("minStock") != null ? doc.getInteger("minStock") : 0,
                    doc.getString("expiryDate") != null ? doc.getString("expiryDate") : ""
            );
            products.add(p);
        }
        
        for (Product p : products) {
            Product existing = productController.findById(p.getId());
            if (existing != null) {
                productController.updateStock(p.getId(), p.getStock());
            } else {
                productController.addProduct(p);
            }
        }
        System.out.println("Products downloaded: " + products.size());
    }
    
    public void uploadAll() {
        System.out.println("=== UPLOADING ALL DATA ===");
        uploadProducts();
        System.out.println("=== UPLOAD COMPLETED ===");
    }
    
    public void downloadAll() {
        System.out.println("=== DOWNLOADING ALL DATA ===");
        downloadProducts();
        System.out.println("=== DOWNLOAD COMPLETED ===");
    }
}
