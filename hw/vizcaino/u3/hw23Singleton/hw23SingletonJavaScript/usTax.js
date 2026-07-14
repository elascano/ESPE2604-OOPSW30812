class USTax {
    constructor() {
        if (USTax.instance) {
            return USTax.instance;
        }
        this.taxRate = 0.0825;
        USTax.instance = this;
    }

    static getInstance() {
        return new USTax();
    }

    getTaxRate() {
        return this.taxRate;
    }

    setTaxRate(taxRate) {
        this.taxRate = taxRate;
    }

    calculateTax(amount) {
        return amount * this.taxRate;
    }
}

module.exports = USTax;
