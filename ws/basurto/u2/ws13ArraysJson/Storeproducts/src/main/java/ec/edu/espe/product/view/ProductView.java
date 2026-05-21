/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.product.view;

/**
 *
 * @author Esteban Basurto , CodeBreakers, @ESPE
 */
import ec.edu.espe.products.model.Product;
import java.util.ArrayList;

public class ProductView {
    
    public void printInvoice(ArrayList<Product> products, double subtotal, double tax, double total) {
        System.out.println("\n========= RECEIPT SUMMARY =========");
        System.out.printf("%-15s %-10s %-10s %-10s\n", "Item", "Price", "Qty", "Subtotal");
        System.out.println("----------------------------------------");
        
        for (Product p : products) {
            System.out.printf("%-15s $%-9.2f %-10d $%-9.2f\n", 
                    p.getName(), p.getPrice(), p.getQuantity(), p.getSubtotal());
        }
        
        System.out.println("----------------------------------------");
        System.out.printf("Net Subtotal: $%.2f\n", subtotal);
        System.out.printf("Tax (15%%):     $%.2f\n", tax);
        System.out.printf("TOTAL DUE:    $%.2f\n", total);
        System.out.println("========================================");
    }

    public void showMessage(String message) {
        System.out.println("[INFO] " + message);
    }
}