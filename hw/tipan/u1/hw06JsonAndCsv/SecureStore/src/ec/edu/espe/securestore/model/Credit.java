/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.securestore.model;

/**
 *
 * @author ronal
 */
public class Credit {
    private String clientName;
    private double amount;

    public Credit(String clientName, double amount) {
        this.clientName = clientName;
        this.amount = amount;
    }

    public String getClientName() { return clientName; }
    public double getAmount() { return amount; }

    @Override
    public String toString() {
        return "Credit{" + "clientName=" + clientName + ", amount=" + amount + '}';
    }
}
