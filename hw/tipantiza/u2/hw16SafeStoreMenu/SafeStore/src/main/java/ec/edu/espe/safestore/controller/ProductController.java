
package ec.edu.espe.safestore.controller;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.safestore.model.Product;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ProductController {
    
    private static final String FILE_NAME = "products.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private List<Product> products;
    
    public ProductController() {
        products = new ArrayList<>();
        loadFromFile();
    }
    
    private void loadFromFile() {
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
    
    private void saveToFile() {
        try {
            String json = gson.toJson(products);
            java.nio.file.Files.write(java.nio.file.Paths.get(FILE_NAME), json.getBytes());
        } catch (Exception e) {
            System.out.println("Error saving products: " + e.getMessage());
        }
    }
    
    public boolean addProduct(Product product) {
        if (findById(product.getId()) != null) {
            return false;
        }
        products.add(product);
        saveToFile();
        return true;
    }
    
    public boolean updateProduct(Product product) {
        Product existing = findById(product.getId());
        if (existing == null) {
            return false;
        }
        existing.setName(product.getName());
        existing.setWholesalePrice(product.getWholesalePrice());
        existing.setRetailPrice(product.getRetailPrice());
        existing.setStock(product.getStock());
        existing.setMinStock(product.getMinStock());
        existing.setExpiryDate(product.getExpiryDate());
        saveToFile();
        return true;
    }
    
    public boolean deleteProduct(int id) {
        Product existing = findById(id);
        if (existing == null) {
            return false;
        }
        products.remove(existing);
        saveToFile();
        return true;
    }
    
    public Product findById(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
    
    public List<Product> getLowStockProducts() {
        List<Product> lowStock = new ArrayList<>();
        for (Product p : products) {
            if (p.getStock() <= p.getMinStock()) {
                lowStock.add(p);
            }
        }
        return lowStock;
    }
    
    public boolean updateStock(int id, int newStock) {
        Product p = findById(id);
        if (p == null) {
            return false;
        }
        p.setStock(newStock);
        saveToFile();
        return true;
    }
}
