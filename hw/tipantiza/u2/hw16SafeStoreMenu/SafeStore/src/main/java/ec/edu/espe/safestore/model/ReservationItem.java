
package ec.edu.espe.safestore.model;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */

public class ReservationItem {
    private int productId;
    private String productName;
    private int quantity;
    private double unitPrice;
    private double totalPrice;
    
    public ReservationItem() {}
    
    public ReservationItem(int productId, String productName, int quantity, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = quantity * unitPrice;
    }
    
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { 
        this.quantity = quantity;
        this.totalPrice = this.quantity * this.unitPrice;
    }
    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { 
        this.unitPrice = unitPrice;
        this.totalPrice = this.quantity * this.unitPrice;
    }
    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
    
    @Override
    public String toString() {
        return "ReservationItem{productName=" + productName + ", quantity=" + quantity + "}";
    }
}