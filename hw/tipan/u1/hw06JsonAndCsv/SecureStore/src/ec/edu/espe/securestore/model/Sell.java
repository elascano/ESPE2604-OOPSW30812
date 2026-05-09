/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.securestore.model;

/**
 *
 * @author ronal
 */
public class Sell {
    private int id;
    private Product product;
    private int quantity;
    private double total;

    public Sell(int id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.total = product.getPrice() * quantity;
    }

    public int getId() { return id; }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getTotal() { return total; }

    @Override
    public String toString() {
        return "Sell{" + "id=" + id + ", product=" + product.getName() + ", quantity=" + quantity + ", total=" + total + '}';
    }
}
