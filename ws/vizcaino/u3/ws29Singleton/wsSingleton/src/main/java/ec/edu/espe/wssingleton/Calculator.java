/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.wssingleton;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class Calculator {

    public static void main(String[] args) {
        UsTax taxService = UsTax.getInstance();

        double saleAmount = 100.0;
        double tax = taxService.calculateTax(saleAmount);
        double total = saleAmount + tax;

        System.out.println("Sale Amount: $" + saleAmount);
        System.out.println("Applied Tax Rate: " + (taxService.getTaxRate() * 100) + "%");
        System.out.println("Calculated Tax: $" + tax);
        System.out.println("Total Sale: $" + total);
    }
}