package ec.edu.espe.observerpattern.view;

import ec.edu.espe.observerpattern.model.IBM;
import ec.edu.espe.observerpattern.model.Investor;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class Application {

    public static void main(String[] args) {

        IBM ibm = new IBM("IBM", 120.00);

        Investor investor1 = new Investor("Sorros");
        Investor investor2 = new Investor("Berkshire");

        ibm.addInvestor(investor1);
        ibm.addInvestor(investor2);

        ibm.setPrice(121.00);

        ibm.setSymbol("IBM Corporation");

        ibm.removeInvestor(investor1);

        ibm.setPrice(125.00);
    }
}