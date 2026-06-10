
package ec.edu.espe.safestore.controller;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */
import ec.edu.espe.safestore.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ReportController {
    
    private ProductController productController;
    
    public ReportController() {
        productController = new ProductController();
    }
    
    public List<Product> getSlowMovingProducts() {
        List<Product> slowMoving = new ArrayList<>();
        for (Product p : productController.getAllProducts()) {
            double turnoverRate = (double) p.getStock() / (p.getMinStock() + 1);
            if (turnoverRate < 0.5) {
                slowMoving.add(p);
            }
        }
        return slowMoving;
    }
    
    public double calculateTurnoverRate(Product product) {
        return (double) product.getStock() / (product.getMinStock() + 1);
    }
    
    public String getRecommendation(Product product) {
        double rate = calculateTurnoverRate(product);
        if (rate < 0.2) return "Consider discount to liquidate";
        if (rate < 0.5) return "Reduce supplier orders";
        return "Monitor sales";
    }
    
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("=== SLOW MOVING PRODUCTS REPORT ===\n");
        report.append("Date: ").append(java.time.LocalDate.now()).append("\n\n");
        
        for (Product p : getSlowMovingProducts()) {
            report.append("Product: ").append(p.getName()).append("\n");
            report.append("  Current Stock: ").append(p.getStock()).append("\n");
            report.append("  Minimum Stock: ").append(p.getMinStock()).append("\n");
            report.append("  Turnover Rate: ").append(String.format("%.2f", calculateTurnoverRate(p))).append("\n");
            report.append("  Recommendation: ").append(getRecommendation(p)).append("\n\n");
        }
        
        if (getSlowMovingProducts().isEmpty()) {
            report.append("No slow moving products detected\n");
        }
        
        return report.toString();
    }
}
