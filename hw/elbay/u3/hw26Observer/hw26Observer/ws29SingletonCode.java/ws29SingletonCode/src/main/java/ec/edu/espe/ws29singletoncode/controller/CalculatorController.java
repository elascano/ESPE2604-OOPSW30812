package controller;

import model.USTax;
import view.CalculatorView;

public class CalculatorController {
    private CalculatorView view;

    public CalculatorController(CalculatorView view) {
        this.view = view;
    }

    public void runDefaultCalculation() {
        USTax tax = USTax.getInstance();
        float total = tax.salesTotal();
        view.displayResult(total);
    }
    
    public void runInteractiveCalculation() {
        float amount = view.getInputAmount();
        float taxRate = view.getInputTaxRate();
        
        USTax tax = USTax.getInstance();
        float total = tax.calculateTax(amount, taxRate);
        
        view.displayResult(total);
        view.closeScanner();
    }
}