import { IBM } from '../model/ibm.js';
import { Investor } from '../model/investor.js';
//@author Christopher Lomas,<CodeBros,@ESPE>
class StockController {
    startApplication() {
        const s = new Investor("Sorros");
        const b = new Investor("Berkshire");

        const ibm = new IBM("IBM", 120.00);
        ibm.addObserver(s);
        ibm.addObserver(b);

        ibm.price = 120.10;
        ibm.price = 121.00;
        ibm.price = 120.50;
        ibm.price = 120.75;
        ibm.symbol = "IBMTEST";
    }
}


const controller = new StockController();
controller.startApplication();