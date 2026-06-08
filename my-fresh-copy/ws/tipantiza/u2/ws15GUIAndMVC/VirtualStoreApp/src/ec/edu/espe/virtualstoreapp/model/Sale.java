
package ec.edu.espe.virtualstoreapp.model;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
public class Sale {
    private String customer;
    private Date date;
    private ArrayList<CartItem> items;
    private double subtotal;
    private double tax;
    private double total;

    public Sale(String customer, Date date, ArrayList<CartItem> items, double subtotal, double tax, double total) {
        this.customer = customer;
        this.date = date;
        this.items = items;
        this.subtotal = subtotal;
        this.tax = tax;
        this.total = total;
    }

    public String getCustomer() { return customer; }
    public Date getDate() { return date; }
    public ArrayList<CartItem> getItems() { return items; }
    public double getSubtotal() { return subtotal; }
    public double getTax() { return tax; }
    public double getTotal() { return total; }
    
}
