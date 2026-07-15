package ec.edu.espe.ws29singletoncalculator.controller;

import ec.edu.espe.ws29singletoncalculator.model.USTax;
import ec.edu.espe.ws29singletoncalculator.view.CalculatorView;

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