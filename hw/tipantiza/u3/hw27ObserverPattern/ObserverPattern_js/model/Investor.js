const IInvestor = require('./IInvestor');

class Investor extends IInvestor {
    constructor(name) {
        super();
        this._name = name;
    }

    update(stock, args) {
        console.log(`Notified observer ${this._name}`);
        if (typeof args === 'string') {
            console.log(`The symbol of ${stock.getSymbol()} changed to: ${args}`);
        } else if (typeof args === 'number') {
            console.log(`The price of ${stock.getSymbol()} changed to: ${args}`);
        }
    }
}

module.exports = Investor;