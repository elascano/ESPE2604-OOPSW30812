class Stock {
    constructor() {
        if (this.constructor === Stock) {
            throw new Error("Cannot instantiate abstract class Stock");
        }
        this.symbol = "";
        this.price = 0.0;
        this.investors = [];
    }

    addObserver(iinvestor) {
        this.investors.push(iinvestor);
    }

    deleteObserver(iinvestor) {
        const index = this.investors.indexOf(iinvestor);
        if (index > -1) {
            this.investors.splice(index, 1);
        }
    }

    notifyObservers(args) {
        for (let i = 0; i < this.investors.length; i++) {
            this.investors[i].update(this, args);
        }
    }

    getSymbol() {
        throw new Error("Method 'getSymbol()' must be implemented.");
    }

    getPrice() {
        throw new Error("Method 'getPrice()' must be implemented.");
    }
}

module.exports = Stock;