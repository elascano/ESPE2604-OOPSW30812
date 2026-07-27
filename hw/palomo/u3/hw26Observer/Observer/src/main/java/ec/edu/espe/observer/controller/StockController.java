/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.observer.controller;

import ec.edu.espe.observer.model.IBM;
import ec.edu.espe.observer.model.Financier;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class StockController {
    public void startApplication() {
        Financier s = new Financier("Sorros");
        Financier b = new Financier("Berkshire");

        IBM ibm = new IBM("IBM", 120.00);
        ibm.addObserver(s);
        ibm.addObserver(b);

        ibm.setPrice(120.10);
        ibm.setPrice(121.00);
        ibm.setPrice(120.50);
        ibm.setPrice(120.75);
        ibm.setSymbol("IBMTEST");
    }

    public static void main(String[] args) {
        new StockController().startApplication();
    }
}
