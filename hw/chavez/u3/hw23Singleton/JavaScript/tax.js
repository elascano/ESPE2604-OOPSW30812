class tax {

    static instance = null;
    constructor() {
        if (tax.instance != null) {
            return tax.instance;
        }

        this.percentage = 15.0;
        tax.instance = this;
    }
    static getInstance() {
        if (tax.instance == null) {
            tax.instance = new tax();
        }
        return tax.instance;
    }
    updatetaxPercentage(p) {
        this.percentage = p;
    }
    getPercentage() {
        return this.percentage;
    }

    salesTotal(amount) {
        return amount + (amount * this.percentage / 100);
    }
}

module.exports = tax;