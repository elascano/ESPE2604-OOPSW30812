package ec.edu.espe.ws29singletoncalculator.view;

import ec.edu.espe.ws29singletoncalculator.controller.CalculatorController;
import ec.edu.espe.ws29singletoncalculator.model.USTax;
import ec.edu.espe.ws29singletoncalculator.view.CalculatorView;
/**
 *
 * @author Esteban Basurto,CodeBreakers,@ESPE
 */
public class calculator {
    public static void main(String args[]) {
        USTax tax = USTax.getInstance();
        tax.salesTotal();
        tax = new USTax();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(view);

        controller.runInteractiveCalculation();
       
    }
}