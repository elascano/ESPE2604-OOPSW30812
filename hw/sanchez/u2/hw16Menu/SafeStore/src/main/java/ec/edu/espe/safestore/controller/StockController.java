
package ec.edu.espe.safestore.controller;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */

import ec.edu.espe.safestore.model.Product;
import java.util.ArrayList;
import java.util.List;

public class StockController {
    
    private ProductController productController;
    
    public StockController() {
        productController = new ProductController();
    }
    
    public List<Product> getLowStockProducts() {
        return productController.getLowStockProducts();
    }
    
    public List<Product> getCriticalStockProducts() {
        List<Product> critical = new ArrayList<>();
        for (Product p : productController.getAllProducts()) {
            if (p.getStock() <= p.getMinStock() / 2) {
                critical.add(p);
            }
        }
        return critical;
    }
    
    public boolean updateStock(int productId, int newStock) {
        return productController.updateStock(productId, newStock);
    }
    
    public boolean updateMinStock(int productId, int newMinStock) {
        Product p = productController.findById(productId);
        if (p == null) {
            return false;
        }
        p.setMinStock(newMinStock);
        productController.updateProduct(p);
        return true;
    }
    
    public int calculateSuggestedOrder(Product product) {
        int suggested = product.getMinStock() * 2 - product.getStock();
        return suggested < 0 ? product.getMinStock() : suggested;
    }
    
    public List<String> generateOrderList() {
        List<String> orderList = new ArrayList<>();
        for (Product p : getLowStockProducts()) {
            orderList.add(p.getName() + " - Order " + calculateSuggestedOrder(p) + " units");
        }
        return orderList;
    }
}