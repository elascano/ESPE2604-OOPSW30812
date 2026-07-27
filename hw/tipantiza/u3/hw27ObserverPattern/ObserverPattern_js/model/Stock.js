class Stock {
    constructor() {
        this._symbol = "";
        this._price = 0.0;
        this._investors = [];
    }

    addObserver(investor) {
        this._investors.push(investor);
    }

    deleteObserver(investor) {
        const index = this._investors.indexOf(investor);
        if (index > -1) {
            this._investors.splice(index, 1);
        }
    }

    notifyObservers(args) {
        for (const investor of this._investors) {
            investor.update(this, args);
        }
    }

    getSymbol() {
        return this._symbol;
    }

    getPrice() {
        return this._price;
    }
}

module.exports = Stock;