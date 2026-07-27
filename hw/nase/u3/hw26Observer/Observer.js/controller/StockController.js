import { Investor } from '../model/Investor.js';
import { IBM } from '../model/IBM.js';

//Jennyfer Nase
export class StockController {
    constructor(view) {
        this.view = view;
    }

    startSimulation() {
        this.view.printWelcome();

        const s = new Investor("Sorros");
        const b = new Investor("Berkshire");

        const ibm = new IBM("IBM", 120.00);

        ibm.addObserver(s);
        ibm.addObserver(b);

        ibm.setPrice(120.10);
        ibm.setPrice(121.00);
        ibm.setPrice(120.50);
        ibm.setPrice(120.75);
        ibm.setSymbol("IBMTEST");
    }
}