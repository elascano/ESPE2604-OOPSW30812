class Tax {
    static instance = null;

    constructor() {
        if (Tax.instance) {
            return Tax.instance;
        }

        console.log("\nInitializing instance\n");

        this.percentage = 0;
        Tax.instance = this;
    }

    static getInstance() {
        if (Tax.instance === null) {
            Tax.instance = new Tax();
        }

        return Tax.instance;
    }

    updateTaxPercentage(p) {
        this.percentage = p;
    }

    getPercentage() {
        return this.percentage;
    }

    salesTotal(price) {
        return price * this.percentage;
    }
}

export default Tax;