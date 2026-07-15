class Tax {
    constructor() {
        if (Tax.instance) {
            return Tax.instance;
        }

        this.percentage = 0.0;
        Tax.instance = this;
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