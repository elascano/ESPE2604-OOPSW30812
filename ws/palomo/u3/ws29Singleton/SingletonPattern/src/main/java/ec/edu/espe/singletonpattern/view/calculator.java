/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.singletonpattern.view;

import ec.edu.espe.singletonpattern.controller.CalculatorController;
import ec.edu.espe.singletonpattern.model.USTax;
import ec.edu.espe.singletonpattern.view.CalculatorView;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
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
