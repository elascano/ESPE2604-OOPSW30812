/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.singletonpattern.view;

import java.util.Scanner;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class CalculatorView {
    private Scanner scanner;

    public CalculatorView() {
        this.scanner = new Scanner(System.in);
    }

    public float getInputAmount() {
        System.out.print("Enter the subtotal amount: ");
        return scanner.nextFloat();
    }

    public float getInputTaxRate() {
        System.out.print("Enter the tax rate percentage: ");
        return scanner.nextFloat();
    }
    
    public void displayResult(float total) {
        System.out.println("=======================================");
        System.out.println("Total sales with tax: $" + total);
        System.out.println("=======================================");
    }

    public void closeScanner() {
        scanner.close();
    }
}
