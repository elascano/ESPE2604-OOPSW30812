package ec.edu.espe.safestore.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */
public class ProductManagement {
    
    public static class Product {
        private int id;
        private String name;
        private int stock;
        private double retailPrice;
        private double wholesalePrice;
        
        public Product(int id, String name, int stock, double retailPrice, double wholesalePrice) {
            this.id = id;
            this.name = name;
            this.stock = stock;
            this.retailPrice = retailPrice;
            this.wholesalePrice = wholesalePrice;
        }
        
        public int getId() { return id; }
        public String getName() { return name; }
        public int getStock() { return stock; }
        public double getRetailPrice() { return retailPrice; }
        public double getWholesalePrice() { return wholesalePrice; }
        public void setStock(int stock) { this.stock = stock; }
    }
    
    private static List<Product> products = new ArrayList<>();
    
    static {
        // Initialize with sample products
        products.add(new Product(1, "Laptop", 50, 800.00, 750.00));
        products.add(new Product(2, "Mouse", 100, 25.00, 20.00));
        products.add(new Product(3, "Keyboard", 75, 45.00, 38.00));
        products.add(new Product(4, "Monitor", 30, 200.00, 180.00));
        products.add(new Product(5, "Printer", 5, 150.00, 130.00));
    }
    
    public static Product findById(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    
    public static void updateProductStock(int productId, int newStock) {
        Product p = findById(productId);
        if (p != null) {
            p.setStock(newStock);
        }
    }
    
    public static List<Product> getAllProducts() {
        return products;
    }
}