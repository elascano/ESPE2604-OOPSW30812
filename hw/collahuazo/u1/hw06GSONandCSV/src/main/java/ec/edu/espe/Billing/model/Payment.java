/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.Billing.model;

/**
 *
 * @author Didier Elbay  <Code_Bros , @ESPE>
 */
public class Payment {
    private double moneyPurchased,change;
    private int paymentMethod;

    public Payment() {
        this.moneyPurchased =0;
        this.change = 0;
        this.paymentMethod = 0;
    }

    public Payment(double moneyPurchased, double change, int paymentMethod) {
        this.moneyPurchased = moneyPurchased;
        this.change = change;
        this.paymentMethod = paymentMethod;
    }

    public double getMoneyPurchased() {
        return moneyPurchased;
    }

    public void setMoneyPurchased(double moneyPurchased) {
        this.moneyPurchased = moneyPurchased;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    
    
    
}
