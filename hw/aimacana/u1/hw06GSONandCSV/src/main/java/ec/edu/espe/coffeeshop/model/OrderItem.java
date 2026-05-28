package ec.edu.espe.coffeeshop.model;

public class OrderItem {
    private String orderItemId;
    private int quantity;
    private double subtotal;
    private Product product;

    public OrderItem(String orderItemId, Product product, int quantity) {
        this.orderItemId = orderItemId;
        this.product = product;
        this.quantity = quantity;
        this.subtotal = calculateSubtotal();
    }

    public double calculateSubtotal() {
        if (product != null) {
            return product.getPrice() * quantity;
        }
        return 0.0;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public Product getProduct() {
        return product;
    }
}
