/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.tax;

/**
 *
 * @author Odalys Chavez , CodeBreakers, @ESPE
 */
public class TaxCalculator {

    public static void main(String[] args) {

        Tax tax = Tax.getInstance();
        tax=new Tax();
        tax.updateTaxPercentage(15.0f);

        float subtotal = 250.0f;

        System.out.println("Tax Percentage: " + tax.getPercentage() + "%");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Total with Tax: $" + tax.salesTotal(subtotal));
    }
}
    

