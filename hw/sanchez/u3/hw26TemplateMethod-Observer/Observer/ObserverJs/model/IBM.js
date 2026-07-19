const Stock = require("./Stock");

class IBM extends Stock {

    constructor(symbol, price) {
        super(symbol, price);
    }
}

module.exports = IBM;