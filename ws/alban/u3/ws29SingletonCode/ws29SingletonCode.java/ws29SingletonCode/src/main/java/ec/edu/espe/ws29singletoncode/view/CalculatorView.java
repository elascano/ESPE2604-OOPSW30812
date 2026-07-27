package view;

import java.util.Scanner;

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