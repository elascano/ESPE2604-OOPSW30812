
package ec.edu.espe.safestore.controller;
/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.safestore.model.Sale;
import ec.edu.espe.safestore.model.SaleItem;
import ec.edu.espe.safestore.model.Product;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SaleController {
    
    private static final String SALES_FILE = "sales.json";
    private static final String HOLD_FILE = "sales_hold.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private List<Sale> sales;
    private Sale pendingSale;
    private ProductController productController;
    
    public SaleController() {
        sales = new ArrayList<>();
        productController = new ProductController();
        loadSales();
        loadHold();
    }
    
    private void loadSales() {
        try {
            File file = new File(SALES_FILE);
            if (file.exists()) {
                String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                Type type = new TypeToken<ArrayList<Sale>>(){}.getType();
                List<Sale> loaded = gson.fromJson(content, type);
                if (loaded != null) {
                    sales = loaded;
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading sales: " + e.getMessage());
        }
    }
    
    private void saveSales() {
        try {
            String json = gson.toJson(sales);
            java.nio.file.Files.write(java.nio.file.Paths.get(SALES_FILE), json.getBytes());
        } catch (Exception e) {
            System.out.println("Error saving sales: " + e.getMessage());
        }
    }
    
    private void saveHold() {
        try {
            String json = gson.toJson(pendingSale);
            java.nio.file.Files.write(java.nio.file.Paths.get(HOLD_FILE), json.getBytes());
        } catch (Exception e) {
            System.out.println("Error saving hold sale: " + e.getMessage());
        }
    }
    
    private void loadHold() {
        try {
            File file = new File(HOLD_FILE);
            if (file.exists()) {
                String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                pendingSale = gson.fromJson(content, Sale.class);
            }
        } catch (Exception e) {
            System.out.println("Error loading hold sale: " + e.getMessage());
        }
    }
    
    public void startNewSale(int saleId, String customerName, String saleType, String paymentMethod) {
        pendingSale = new Sale(saleId, customerName, saleType, paymentMethod);
    }
    
    public boolean addProductToCurrentSale(int productId, int quantity) {
        if (pendingSale == null) {
            return false;
        }
        
        Product product = productController.findById(productId);
        if (product == null || quantity > product.getStock()) {
            return false;
        }
        
        double unitPrice = "wholesale".equalsIgnoreCase(pendingSale.getSaleType()) && quantity >= 12 
                           ? product.getWholesalePrice() : product.getRetailPrice();
        
        SaleItem item = new SaleItem(productId, product.getName(), quantity, unitPrice);
        pendingSale.addItem(item);
        
        productController.updateStock(productId, product.getStock() - quantity);
        return true;
    }
    
    public Sale getCurrentSale() {
        return pendingSale;
    }
    
    public boolean finalizeSale() {
        if (pendingSale == null || pendingSale.getItems().isEmpty()) {
            return false;
        }
        
        sales.add(pendingSale);
        saveSales();
        pendingSale = null;
        return true;
    }
    
    public void holdCurrentSale() {
        if (pendingSale != null) {
            saveHold();
            pendingSale = null;
        }
    }
    
    public void resumeHoldSale() {
        loadHold();
    }
    
    public List<Sale> getAllSales() {
        return new ArrayList<>(sales);
    }
    
    public Sale findSaleById(int id) {
        for (Sale s : sales) {
            if (s.getSaleId() == id) {
                return s;
            }
        }
        return null;
    }
}
