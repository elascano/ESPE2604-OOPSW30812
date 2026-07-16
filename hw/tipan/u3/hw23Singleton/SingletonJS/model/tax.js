class Tax {
    constructor() {
        this._percentage = 0;
    }

    static getInstance() {
        if (!Tax._instance) {
            Tax._instance = new Tax();
        }
        return Tax._instance;
    }

    updateTaxPercentage(percentage) {
        this._percentage = percentage;
    }

    getPercentage() {
        return this._percentage;
    }

    salesTotal(subtotal) {
        const taxAmount = subtotal * (this._percentage / 100);
        return subtotal + taxAmount;
    }
}

module.exports = { Tax };