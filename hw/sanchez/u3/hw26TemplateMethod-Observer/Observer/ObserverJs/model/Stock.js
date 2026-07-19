class Stock {

    constructor(symbol, price) {
        this.symbol = symbol;
        this.price = price;
        this.investors = [];
    }

    addInvestor(investor) {
        this.investors.push(investor);
    }

    removeInvestor(investor) {
        const index = this.investors.indexOf(investor);

        if (index !== -1) {
            this.investors.splice(index, 1);
        }
    }

    notifyInvestors() {
        this.investors.forEach(investor => {
            investor.update(this);
        });
    }

    setSymbol(symbol) {
        this.symbol = symbol;
        this.notifyInvestors();
    }

    setPrice(price) {
        this.price = price;
        this.notifyInvestors();
    }

    getSymbol() {
        return this.symbol;
    }

    getPrice() {
        return this.price;
    }
}

module.exports = Stock;