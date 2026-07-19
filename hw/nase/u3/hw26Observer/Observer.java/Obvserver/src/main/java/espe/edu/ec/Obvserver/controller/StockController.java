/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espe.edu.ec.Obvserver.controller;

import espe.edu.ec.Obvserver.model.IBM;
import espe.edu.ec.Obvserver.model.Investor;
import espe.edu.ec.Obvserver.view.Console;

/**
 *
 * @author Jennyfer Nase
 */
public class StockController {
    private Console console;

    public StockController(Console console) {
        this.console = console;
    }

    public void startSimulation() {
        console.printWelcome();

        Investor s = new Investor("Sorros");
        Investor b = new Investor("Berkshire");

        IBM ibm = new IBM("IBM", 120.00);

        ibm.addObserver(s);
        ibm.addObserver(b);

        ibm.setPrice(120.10);
        ibm.setPrice(121.00);
        ibm.setPrice(120.50);
        ibm.setPrice(120.75);
        ibm.setSymbol("IBMTEST");
    }
}