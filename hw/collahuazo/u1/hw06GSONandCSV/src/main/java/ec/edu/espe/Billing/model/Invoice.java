/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.Billing.model;
public class Invoice {
    private int IncoiceNumber;
    private String date,cashier,customer;
    private double total,subtotal;
    
    

    public Invoice() {
        this.IncoiceNumber = 0;
        this.date = null;
        this.cashier = null;
        this.customer = null;
        this.total = 0;
        this.subtotal = 0;
    }

    public Invoice(int IncoiceNumber, String date, String cashier, String customer, double total, double subtotal) {
        this.IncoiceNumber = IncoiceNumber;
        this.date = date;
        this.cashier = cashier;
        this.customer = customer;
        this.total = total;
        this.subtotal = subtotal;
    }

    public int getIncoiceNumber() {
        return IncoiceNumber;
    }

    public void setIncoiceNumber(int IncoiceNumber) {
        this.IncoiceNumber = IncoiceNumber;
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
    
    
    
}
