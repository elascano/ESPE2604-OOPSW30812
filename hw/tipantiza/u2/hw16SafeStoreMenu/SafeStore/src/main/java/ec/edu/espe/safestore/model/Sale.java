
package ec.edu.espe.safestore.model;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sale {
    private int saleId;
    private String customerName;
    private LocalDateTime date;
    private List<SaleItem> items;
    private double subtotal;
    private double tax;
    private double total;
    private String paymentMethod;
    private String saleType;
    
    public Sale() {
        this.items = new ArrayList<>();
        this.date = LocalDateTime.now();
    }
    
    public Sale(int saleId, String customerName, String saleType, String paymentMethod) {
        this.saleId = saleId;
        this.customerName = customerName;
        this.saleType = saleType;
        this.paymentMethod = paymentMethod;
        this.items = new ArrayList<>();
        this.date = LocalDateTime.now();
    }
    
    public int getSaleId() { return saleId; }
    public void setSaleId(int saleId) { this.saleId = saleId; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
    public List<SaleItem> getItems() { return items; }
    public void setItems(List<SaleItem> items) { this.items = items; }
    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
    public double getTax() { return tax; }
    public void setTax(double tax) { this.tax = tax; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public String getSaleType() { return saleType; }
    public void setSaleType(String saleType) { this.saleType = saleType; }
    
    public void addItem(SaleItem item) {
        items.add(item);
        calculateTotals();
    }
    
    private void calculateTotals() {
        subtotal = items.stream().mapToDouble(SaleItem::getTotalPrice).sum();
        tax = subtotal * 0.15;
        total = subtotal + tax;
    }
    
    @Override
    public String toString() {
        return "Sale{saleId=" + saleId + ", customerName=" + customerName + ", total=" + total + "}";
    }
}
