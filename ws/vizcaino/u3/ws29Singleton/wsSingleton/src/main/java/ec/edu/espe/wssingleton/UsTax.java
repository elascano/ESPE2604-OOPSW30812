/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.wssingleton;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class UsTax {

    private static UsTax instance;
    private double taxRate;

    private UsTax() {
        taxRate = 0.0825;
    }

    public static synchronized UsTax getInstance() {
        if (instance == null) {
            instance = new UsTax();
        }
        return instance;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double calculateTax(double amount) {
        return amount * taxRate;
    }
}