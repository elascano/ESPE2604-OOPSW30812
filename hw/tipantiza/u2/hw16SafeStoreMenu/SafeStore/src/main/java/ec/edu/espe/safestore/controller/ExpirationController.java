
package ec.edu.espe.safestore.controller;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */
import ec.edu.espe.safestore.model.Product;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ExpirationController {
    
    private ProductController productController;
    private int alertDays;
    
    public ExpirationController() {
        productController = new ProductController();
        this.alertDays = 30;
    }
    
    public void setAlertDays(int days) {
        this.alertDays = days;
    }
    
    public int getAlertDays() {
        return alertDays;
    }
    
    public List<Product> getExpiringSoonProducts() {
        List<Product> expiring = new ArrayList<>();
        LocalDate today = LocalDate.now();
        
        for (Product p : productController.getAllProducts()) {
            if (p.getExpiryDate() != null && !p.getExpiryDate().isEmpty()) {
                LocalDate expiry = LocalDate.parse(p.getExpiryDate());
                long daysLeft = ChronoUnit.DAYS.between(today, expiry);
                if (daysLeft <= alertDays && daysLeft > 0) {
                    expiring.add(p);
                }
            }
        }
        return expiring;
    }
    
    public List<Product> getExpiredProducts() {
        List<Product> expired = new ArrayList<>();
        LocalDate today = LocalDate.now();
        
        for (Product p : productController.getAllProducts()) {
            if (p.getExpiryDate() != null && !p.getExpiryDate().isEmpty()) {
                LocalDate expiry = LocalDate.parse(p.getExpiryDate());
                if (expiry.isBefore(today)) {
                    expired.add(p);
                }
            }
        }
        return expired;
    }
    
    public double calculateDiscount(Product product) {
        if (product.getExpiryDate() == null || product.getExpiryDate().isEmpty()) {
            return 0;
        }
        
        LocalDate today = LocalDate.now();
        LocalDate expiry = LocalDate.parse(product.getExpiryDate());
        long daysLeft = ChronoUnit.DAYS.between(today, expiry);
        
        if (daysLeft <= 7 && daysLeft > 3) {
            return 0.30;
        } else if (daysLeft <= 15 && daysLeft > 7) {
            return 0.20;
        } else if (daysLeft <= 30 && daysLeft > 15) {
            return 0.10;
        } else if (daysLeft <= 0) {
            return 0.50;
        }
        return 0;
    }
    
    public String getDiscountDescription(Product product) {
        double discount = calculateDiscount(product);
        if (discount == 0.30) return "30% (Last week)";
        if (discount == 0.20) return "20% (Two weeks)";
        if (discount == 0.10) return "10% (One month)";
        if (discount == 0.50) return "50% (EXPIRED - Do not sell)";
        return "No discount";
    }
}
