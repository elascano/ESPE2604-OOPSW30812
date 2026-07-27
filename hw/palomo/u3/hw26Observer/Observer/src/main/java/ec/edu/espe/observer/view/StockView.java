/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.observer.view;

import ec.edu.espe.observer.model.Stock;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class StockView {
    public static void printNotification(String investorName, Stock stock, Object args) {
        System.out.println("Notified observer " + investorName);
        if (args instanceof String) {
            System.out.println("The symbol of " + stock.getSymbol() + " changed to: " + args);
        } else if (args instanceof Double) {
            System.out.println("The price of " + stock.getSymbol() + " changed to: " + args);
        }
    }
}
