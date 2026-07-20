
package ec.edu.espe.Observer.controller;
import ec.edu.espe.Observer.model.IBM;
import ec.edu.espe.Observer.model.Investor;
/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public class StockController {
    public void startApplication() {
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

    public static void main(String[] args) {
        new StockController().startApplication();
    }
}
