/**
 * @author Cristian Palomo, Error 404, @ESPE
 */
import { Financier } from "../model/Financier.js";
import { IBM } from "../model/IBM.js";

export class StockController {
    startApplication() {
        const s = new Financier("Sorros");
        const b = new Financier("Berkshire");

        const ibm = new IBM("IBM", 120.0);
        ibm.addObserver(s);
        ibm.addObserver(b);

        ibm.setPrice(120.1);
        ibm.setPrice(121.0);
        ibm.setPrice(120.5);
        ibm.setPrice(120.75);
        ibm.setSymbol("IBMTEST");
    }
}

new StockController().startApplication();
