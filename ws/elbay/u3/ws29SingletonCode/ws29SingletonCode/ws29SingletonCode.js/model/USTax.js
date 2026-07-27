class USTax {
    static instance = null;

    constructor() {
        if (USTax.instance) {
            return USTax.instance;
        }
        USTax.instance = this;
    }

    static getInstance() {
        if (!USTax.instance) {
            USTax.instance = new USTax();
        }
        return USTax.instance;
    }

    salesTotal() {
        const taxRate = 0.12;
        const subtotal = 100.0;
        return subtotal + (subtotal * taxRate);
    }

    calculateTax(amount, taxRate) {
        return amount + (amount * (taxRate / 100));
    }
}

module.exports = USTax;