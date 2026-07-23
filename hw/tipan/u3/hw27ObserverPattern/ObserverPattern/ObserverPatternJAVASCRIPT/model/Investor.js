const IInvestor = require("./IInvestor");

class Investor extends IInvestor {

    constructor(name) {
        super();
        this.name = name;
    }

    update(stock) {
        console.log(
            `Notified ${this.name} of ${stock.symbol} change to ${stock.price}`
        );
    }

    getName() {
        return this.name;
    }
}

module.exports = Investor;