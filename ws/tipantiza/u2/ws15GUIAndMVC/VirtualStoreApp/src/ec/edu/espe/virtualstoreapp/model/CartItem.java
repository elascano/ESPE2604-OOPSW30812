
package ec.edu.espe.virtualstoreapp.model;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
public class CartItem {
    private String name;
    private double price;
    private int quantity;
    private double subtotal;

    public CartItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.subtotal = price * quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public double getSubtotal() { return subtotal; }
    
    public void setQuantity(int quantity) { 
        this.quantity = quantity;
        this.subtotal = this.price * quantity;
    }
    
}
