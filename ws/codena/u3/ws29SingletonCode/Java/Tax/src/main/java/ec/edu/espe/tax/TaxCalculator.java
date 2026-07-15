/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.tax;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class TaxCalculator {

    public static void main(String[] args) {
        

        Tax iva = Tax.getInstance();
        
        Tax anotherTax = Tax.getInstance();
        
        float percentage = 0.15F;
        float price = 100;
        
        iva.updateTaxPercentage(percentage);
        
        float calculatedPrice = iva.salesTotal(price);
        
        System.out.println("The percentage is: " + iva.getPercentage());
        System.out.println("The price is : " + calculatedPrice + "$");
       
        
    }

}
