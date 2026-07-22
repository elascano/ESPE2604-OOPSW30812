import IBM from "../model/IBM.js";
import Investor from "../model/Investor.js";

const sorros = new Investor("Sorros");
const berkshire = new Investor("Berkshire");

const ibm = new IBM("IBM", 120.00);

ibm.addObserver(sorros);
ibm.addObserver(berkshire);

ibm.setPrice(120.10);
ibm.setPrice(121.00);
ibm.setPrice(120.50);
ibm.setPrice(120.75);

ibm.setSymbol("IBMTEST");