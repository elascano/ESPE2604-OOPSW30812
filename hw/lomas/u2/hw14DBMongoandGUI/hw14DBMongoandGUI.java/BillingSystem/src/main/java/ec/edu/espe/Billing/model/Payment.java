package ec.edu.espe.Billing.model;

public class Payment {
    private String id;
    private String paymentMethod;
    private double amount;

    public Payment(String id, String paymentMethod, double amount) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}
