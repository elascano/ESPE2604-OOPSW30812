/**
 * @author Cristian Palomo, Error 404, @ESPE
 */
export class Stock {
    constructor() {
        if (new.target === Stock) {
            throw new Error("Stock es abstracta, usa una subclase como IBM");
        }
        this.symbol = undefined;
        this.price = undefined;
        this._investors = [];
    }

    addObserver(investor) {
        this._investors.push(investor);
    }

    deleteObserver(investor) {
        this._investors = this._investors.filter((i) => i !== investor);
    }

    notifyObservers(args) {
        for (const investor of [...this._investors]) {
            investor.update(this, args);
        }
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
        this.notifyObservers(Number(price));
    }
}
