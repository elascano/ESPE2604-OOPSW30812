/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.singletonpattern.controller;

import ec.edu.espe.singletonpattern.model.USTax;
import ec.edu.espe.singletonpattern.view.CalculatorView;

/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
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
