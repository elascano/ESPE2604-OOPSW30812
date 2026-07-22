import IInvestor from "./IInvestor.js";

class Investor extends IInvestor {

    constructor(name) {
        super();
        this.name = name;
    }

    update(stock, args) {
        console.log(`Notified observer ${this.name}`);

        if (typeof args === "string") {
            console.log(`The symbol of ${stock.getSymbol()} changed to: ${args}`);
        } else {
            console.log(`The price of ${stock.getSymbol()} changed to: ${args}`);
        }
    }
}

export default Investor;