
package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */

public class ProductManagement {
    private static final String FILE_NAME = "products.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static List<Product> products = new ArrayList<>();
    
    static {
        loadFromFile();
    }
    
    public static class Product {
        private int id;
        private String name;
        private double wholesalePrice;
        private double retailPrice;
        private int stock;
        private int minStock;
        private String expiryDate;
        
        public Product() {}
        
        public Product(int id, String name, double wholesalePrice, double retailPrice, int stock, int minStock, String expiryDate) {
            this.id = id;
            this.name = name;
            this.wholesalePrice = wholesalePrice;
            this.retailPrice = retailPrice;
            this.stock = stock;
            this.minStock = minStock;
            this.expiryDate = expiryDate;
        }
        
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public double getWholesalePrice() { return wholesalePrice; }
        public void setWholesalePrice(double wholesalePrice) { this.wholesalePrice = wholesalePrice; }
        public double getRetailPrice() { return retailPrice; }
        public void setRetailPrice(double retailPrice) { this.retailPrice = retailPrice; }
        public int getStock() { return stock; }
        public void setStock(int stock) { this.stock = stock; }
        public int getMinStock() { return minStock; }
        public void setMinStock(int minStock) { this.minStock = minStock; }
        public String getExpiryDate() { return expiryDate; }
        public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }
        
        public double getPriceByQuantity(int quantity) {
            return (quantity >= 12) ? wholesalePrice : retailPrice;
        }
        
        @Override
        public String toString() {
            return String.format("ID:%d | %s | Stock:%d | Retail:$%.2f | Wholesale:$%.2f | Expires:%s",
                                 id, name, stock, retailPrice, wholesalePrice, expiryDate);
        }
    }
    
    public static void addProduct(Product product) {
        products.add(product);
        saveToFile();
    }
    
    public static void deleteProduct(int id) {
        products.removeIf(p -> p.getId() == id);
        saveToFile();
    }
    
    public static void saveToFile() {
        try {
            String json = gson.toJson(products);
            java.nio.file.Files.write(java.nio.file.Paths.get(FILE_NAME), json.getBytes());
        } catch (Exception e) {
            System.out.println("Error saving products: " + e.getMessage());
        }
    }
    
    public static Product findById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
    
    public static List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
    
    public static void updateProductStock(int id, int newStock) {
        Product p = findById(id);
        if (p != null) {
            p.setStock(newStock);
            saveToFile();
        }
    }
    
    public static void updateProductMinStock(int id, int newMinStock) {
        Product p = findById(id);
        if (p != null) {
            p.setMinStock(newMinStock);
            saveToFile();
        }
    }
    
    private static void loadFromFile() {
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                Type type = new TypeToken<ArrayList<Product>>(){}.getType();
                List<Product> loaded = gson.fromJson(content, type);
                if (loaded != null) {
                    products = loaded;
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading products: " + e.getMessage());
        }
    }
}
