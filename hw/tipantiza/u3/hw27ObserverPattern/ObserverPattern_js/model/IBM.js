const Stock = require('./Stock');

class IBM extends Stock {
    constructor(symbol, price) {
        super();
        this._symbol = symbol;
        this._price = price;
    }

    setPrice(price) {
        this._price = price;
        this.notifyObservers(price);
    }

    setSymbol(symbol) {
        this._symbol = symbol;
        this.notifyObservers(symbol);
    }
}

module.exports = IBM;