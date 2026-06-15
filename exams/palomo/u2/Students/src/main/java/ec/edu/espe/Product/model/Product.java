/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.Product.model;
/**
 *
 * @author Cristian Palmo,Error 404 @ESPE
 */
public class Product {
    private String id;
    private String name;
    private double unitPrice;
    private int quantity;

    // Constructor
    public Product(String id, String name, double unitPrice, int quantity) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    // Regla de negocio solicitada para calcular algún valor numérico
    public double calculateInventoryValue() {
        return this.unitPrice * this.quantity;
    }
}
    
