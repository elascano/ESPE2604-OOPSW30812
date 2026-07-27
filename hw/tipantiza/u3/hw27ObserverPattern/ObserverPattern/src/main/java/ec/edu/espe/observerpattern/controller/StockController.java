
package ec.edu.espe.observerpattern.controller;
import ec.edu.espe.observerpattern.model.IBM;
import ec.edu.espe.observerpattern.model.Investor;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

public class StockController {
    public void runSimulation() {
        Investor s = new Investor("Soros");
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