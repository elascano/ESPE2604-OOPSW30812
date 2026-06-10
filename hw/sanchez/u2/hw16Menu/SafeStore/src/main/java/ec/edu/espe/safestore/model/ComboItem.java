
package ec.edu.espe.safestore.model;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class ComboItem {
    private int productId;
    private String productName;
    private double productPrice;
    private int quantity;
    
    public ComboItem() {}
    
    public ComboItem(int productId, String productName, double productPrice, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }
    
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public double getProductPrice() { return productPrice; }
    public void setProductPrice(double productPrice) { this.productPrice = productPrice; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    @Override
    public String toString() {
        return "ComboItem{productName=" + productName + ", quantity=" + quantity + "}";
    }
}
