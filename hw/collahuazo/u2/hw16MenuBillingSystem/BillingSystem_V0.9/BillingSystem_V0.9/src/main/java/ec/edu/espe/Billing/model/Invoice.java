package ec.edu.espe.Billing.model;

/**
 * @author Brandon Collahuazo, <CodeBros> , @ESPE
 */
public class Invoice {

    private int invoiceNumber;
    private String date;
    private String cashier;
    private String customer;
    private double subtotal;
    private double total;

    public Invoice() {
        this.invoiceNumber = 0;
        this.date = "";
        this.cashier = "";
        this.customer = "";
        this.subtotal = 0.0;
        this.total = 0.0;
    }

    public Invoice(int invoiceNumber, String cashier, String customer) {
        this.invoiceNumber = invoiceNumber;
        this.cashier = cashier;
        this.customer = customer;
        this.date = java.time.LocalDate.now().toString();
        this.subtotal = 0.0;
        this.total = 0.0;
    }

    public void calculateTotals(Product product, int quantity) {
        if (product != null && quantity > 0) {
            this.subtotal = product.getUnitPrice() * quantity;
            this.total = this.subtotal * 1.15;
        }
    }

    private double calculateSubtotal() {
        return Math.round(this.subtotal * 100.0) / 100.0;
    }

    private double calculateIva() {
        double iva = this.subtotal * 0.15;
        return Math.round(iva * 100.0) / 100.0;
    }

    private double calculateTotal() {
        return Math.round(this.total * 100.0) / 100.0;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    public void showInvoiceTicket(String productName, int quantity) {
        String ticket = "";
        ticket += "\n========================================\n";
        ticket += "             TICKET DE VENTA            \n";
        ticket += "========================================\n";
        ticket += "Numero de factura:  " + invoiceNumber + "\n";
        ticket += "Fecha:       " + date + "\n";
        ticket += "Cajero:      " + cashier + "\n";
        ticket += "Cliente:     " + customer + "\n";
        ticket += "----------------------------------------\n";
        ticket += "Producto: " + productName + "\n";
        ticket += "Cantidad de producto: " + quantity + "\n";
        ticket += "----------------------------------------\n";
        ticket += "Subtotal:    $" + calculateSubtotal() + "\n";
        ticket += "IVA (15%):   $" + calculateIva() + "\n";
        ticket += "Total:       $" + calculateTotal() + "\n";
        ticket += "========================================\n";

        System.out.println(ticket);
    }
}