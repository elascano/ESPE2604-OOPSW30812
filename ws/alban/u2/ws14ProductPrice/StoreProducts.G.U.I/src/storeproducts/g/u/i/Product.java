package storeproducts.g.u.i;

public class Product {
    private final String name;
    private final double price;
    private final int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public double getSubtotal() { return this.price * this.quantity; }

    public String toJsonString() {
        return String.format("{\"name\": \"%s\", \"price\": %.2f, \"quantity\": %d, \"subtotal\": %.2f}", 
                name, price, quantity, getSubtotal());
    }
}