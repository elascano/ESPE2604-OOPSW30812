const IInvestor = require('./iInvestor');

class Investor extends IInvestor {
    constructor(name) {
        super();
        this.name = name;
    }

    update(stock, args) {
        process.stdout.write(`Notified observer ${this.name} `);
        if (typeof args === 'string') {
            console.log(`The symbol of ${stock.getSymbol()} changed to: ${args}`);
        } else if (typeof args === 'number') {
            console.log(`The price of ${stock.getSymbol()} changed to: ${args.toFixed(2)}`);
        }
    }
}

module.exports = Investor;