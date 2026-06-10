
package ec.edu.espe.safestore.model;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SupplierInvoice {
    private int invoiceId;
    private int supplierId;
    private String invoiceNumber;
    private LocalDate date;
    private LocalDate dueDate;
    private List<InvoiceItem> items;
    private double subtotal;
    private double tax;
    private double total;
    private String status;
    
    public SupplierInvoice() {
        this.items = new ArrayList<>();
        this.status = "pending";
        this.date = LocalDate.now();
    }
    
    public SupplierInvoice(int invoiceId, int supplierId, String invoiceNumber, LocalDate dueDate) {
        this.invoiceId = invoiceId;
        this.supplierId = supplierId;
        this.invoiceNumber = invoiceNumber;
        this.dueDate = dueDate;
        this.items = new ArrayList<>();
        this.status = "pending";
        this.date = LocalDate.now();
    }
    
    public int getInvoiceId() { return invoiceId; }
    public void setInvoiceId(int invoiceId) { this.invoiceId = invoiceId; }
    public int getSupplierId() { return supplierId; }
    public void setSupplierId(int supplierId) { this.supplierId = supplierId; }
    public String getInvoiceNumber() { return invoiceNumber; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public List<InvoiceItem> getItems() { return items; }
    public void setItems(List<InvoiceItem> items) { this.items = items; }
    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
    public double getTax() { return tax; }
    public void setTax(double tax) { this.tax = tax; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public void addItem(InvoiceItem item) {
        items.add(item);
        calculateTotals();
    }
    
    private void calculateTotals() {
        subtotal = items.stream().mapToDouble(InvoiceItem::getTotalPrice).sum();
        tax = subtotal * 0.15;
        total = subtotal + tax;
    }
    
    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate) && "pending".equals(status);
    }
    
    @Override
    public String toString() {
        return "SupplierInvoice{invoiceId=" + invoiceId + ", supplierId=" + supplierId + ", total=" + total + "}";
    }
}
