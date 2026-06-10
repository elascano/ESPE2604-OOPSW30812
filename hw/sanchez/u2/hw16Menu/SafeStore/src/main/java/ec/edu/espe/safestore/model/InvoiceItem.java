/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.safestore.model;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */

public class InvoiceItem {
    private int productId;
    private String productName;
    private int quantity;
    private double unitCost;
    private double totalPrice;
    
    public InvoiceItem() {}
    
    public InvoiceItem(int productId, String productName, int quantity, double unitCost) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitCost = unitCost;
        this.totalPrice = quantity * unitCost;
    }
    
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { 
        this.quantity = quantity;
        this.totalPrice = this.quantity * this.unitCost;
    }
    public double getUnitCost() { return unitCost; }
    public void setUnitCost(double unitCost) { 
        this.unitCost = unitCost;
        this.totalPrice = this.quantity * this.unitCost;
    }
    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
    
    @Override
    public String toString() {
        return "InvoiceItem{productName=" + productName + ", quantity=" + quantity + ", totalPrice=" + totalPrice + "}";
    }
}