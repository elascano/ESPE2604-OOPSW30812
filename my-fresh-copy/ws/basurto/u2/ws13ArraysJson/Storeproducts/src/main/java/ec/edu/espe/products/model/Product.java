/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.products.model;

/**
 *
 * @author Esteban Basurto , CodeBreakers, @ESPE
 */
public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getSubtotal() {
        return this.price * this.quantity;
    }

    // Converts the object to a JSON string format manually
    public String toJsonString() {
        return String.format("{\"name\": \"%s\", \"price\": %.2f, \"quantity\": %d, \"subtotal\": %.2f}", 
                name, price, quantity, getSubtotal());
    }
}
