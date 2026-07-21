export class Stock {
    constructor() {
        this._symbol = "";
        this._price = 0.0;
        this._investors = [];
    }

    addObserver(investor) {
        this._investors.push(investor);
    }

    deleteObserver(investor) {
        this._investors = this._investors.filter(inv => inv !== investor);
    }

    notifyObservers(args) {
        this._investors.forEach(investor => {
            investor.update(this, args);
        });
    }

    get symbol() {
        return this._symbol;
    }

    set symbol(value) {
        this._symbol = value;
        this.notifyObservers(value);
    }

    get price() {
        return this._price;
    }

    set price(value) {
        this._price = value;
        this.notifyObservers(value);
    }
}