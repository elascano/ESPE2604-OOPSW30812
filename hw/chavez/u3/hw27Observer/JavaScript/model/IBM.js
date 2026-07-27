import Stock from "./Stock.js";

class IBM extends Stock {

    constructor(symbol, price) {
        super();
        this.symbol = symbol;
        this.price = price;
    }

    getSymbol() {
        return this.symbol;
    }

    setSymbol(symbol) {
        this.symbol = symbol;
        this.notifyObservers(symbol);
    }

    getPrice() {
        return this.price;
    }

    setPrice(price) {
        this.price = price;
        this.notifyObservers(price);
    }
}

export default IBM;