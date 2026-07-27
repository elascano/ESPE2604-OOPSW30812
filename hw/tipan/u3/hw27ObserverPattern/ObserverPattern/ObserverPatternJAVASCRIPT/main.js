const IBM = require("./model/IBM");
const Investor = require("./model/Investor");

const ibm = new IBM("IBM", 120.00);

const investor1 = new Investor("Sorros");
const investor2 = new Investor("Berkshire");

ibm.addInvestor(investor1);
ibm.addInvestor(investor2);

ibm.setPrice(121.00);

ibm.setSymbol("IBM Corporation");

ibm.removeInvestor(investor1);

ibm.setPrice(125.00);