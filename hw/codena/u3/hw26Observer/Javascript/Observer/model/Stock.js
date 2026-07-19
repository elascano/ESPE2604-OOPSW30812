class Stock {

    constructor() {
        this.symbol = "";
        this.price = 0;
        this.investors = [];
    }

    addObserver(investor) {
        this.investors.push(investor);
    }

    deleteObserver(investor) {
        this.investors = this.investors.filter(i => i !== investor);
    }

    notifyObservers(args) {
        this.investors.forEach(investor => investor.update(this, args));
    }

    setPrice(price) {
        throw new Error("setPrice() must be implemented.");
    }

    setSymbol(symbol) {
        throw new Error("setSymbol() must be implemented.");
    }
}

module.exports = Stock;