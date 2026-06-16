
/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
package ec.edu.espe.storeapp.model;

public class CartItem {
    private final String productName;
    private final String category;
    private final int quantity;
    private final double subtotal;
    private final double tax;
    private final double total;

    public CartItem(String productName, String category, int quantity, double subtotal, double tax, double total) {
        this.productName = productName;
        this.category = category;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.tax = tax;
        this.total = total;
    }

    public String getProductName() { return productName; }
    public String getCategory() { return category; }
    public int getQuantity() { return quantity; }
    public double getSubtotal() { return subtotal; }
    public double getTax() { return tax; }
    public double getTotal() { return total; }
}