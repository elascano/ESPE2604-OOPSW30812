class Tax {
    static instance = null;

    constructor() {
        this.percentage = 0.0;
    }

    static getInstance() {
        if (Tax.instance === null) {
            Tax.instance = new Tax();
        }
        return Tax.instance;
    }

    updateTaxPercentage(percentage) {
        this.percentage = percentage;
    }

    getPercentage() {
        return this.percentage;
    }

    salesTotal(sale) {
        return sale + (sale * this.percentage / 100);
    }
}

module.exports = Tax;