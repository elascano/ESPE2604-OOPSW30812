/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.singleton.view;
import ec.edu.espe.singleton.model.Tax;
/**
 *
 * @author Ronald Tipan, The_Softwarriors ,@ESPE
 */
public class Singleton {
public static void main(String[] args) {

        Tax tax = Tax.getInstance();

        tax = new Tax();
        
        tax.updateTaxPercentage(15);
        float subtotal = 100;

        System.out.println("Tax percentage: " + tax.getPercentage() + "%");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Total: $" + tax.salesTotal(subtotal));
    }
}
