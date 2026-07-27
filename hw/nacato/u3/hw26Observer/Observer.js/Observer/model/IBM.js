const Stock = require("./Stock");

class IBM extends Stock {

    constructor(symbol, price) {
        super();
        this.symbol = symbol;
        this.price = price;
    }

    setPrice(price) {
        this.price = price;
        this.notifyObservers(price);
    }

    setSymbol(symbol) {
        this.symbol = symbol;
        this.notifyObservers(symbol);
    }

}

module.exports = IBM;