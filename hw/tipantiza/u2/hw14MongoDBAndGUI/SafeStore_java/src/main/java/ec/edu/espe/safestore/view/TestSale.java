package ec.edu.espe.safestore.view;

import org.bson.Document;
import ec.edu.espe.safestore.model.MongoDBConnection;
import java.util.Date;
import java.util.List;

public class TestSale {
    
    public static void main(String[] args) {
        System.out.println("=== TESTING MONGODB SALE ===");
        
        // Connect
        MongoDBConnection.connect();
        
        if (!MongoDBConnection.isConnected()) {
            System.out.println("❌ FAILED: Cannot connect to MongoDB");
            return;
        }
        
        System.out.println("✅ Connected to MongoDB");
        
        // Test 1: Create a test sale
        System.out.println("\n--- TEST 1: Save a sale ---");
        Document testSale = new Document()
            .append("saleId", 100)
            .append("customerName", "Test Customer")
            .append("date", new Date().toString())
            .append("saleType", "Retail")
            .append("paymentMethod", "Cash")
            .append("subtotal", 100.00)
            .append("tax", 15.00)
            .append("total", 115.00)
            .append("items", new java.util.ArrayList<>());
        
        try {
            MongoDBConnection.saveSale(testSale);
            System.out.println("✅ Sale saved successfully");
        } catch (Exception e) {
            System.out.println("❌ Error saving: " + e.getMessage());
            e.printStackTrace();
        }
        
        // Test 2: Read all sales
        System.out.println("\n--- TEST 2: Read all sales ---");
        try {
            List<Document> sales = MongoDBConnection.getAllSales();
            System.out.println("Found " + sales.size() + " sales in database");
            
            for (Document sale : sales) {
                System.out.println("  Sale ID: " + sale.getInteger("saleId"));
                System.out.println("  Customer: " + sale.getString("customerName"));
                System.out.println("  Total: " + sale.getDouble("total"));
                System.out.println("  ---");
            }
        } catch (Exception e) {
            System.out.println("❌ Error reading: " + e.getMessage());
            e.printStackTrace();
        }
        
        MongoDBConnection.close();
        System.out.println("\n=== TEST COMPLETE ===");
    }
}