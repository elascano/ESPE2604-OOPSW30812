class Tax {

    static computeIva(amount, taxPercentage) {

        let taxValue;

        taxValue = amount * taxPercentage / 100;

        return taxValue;
    }

    static computeTotal(amount, taxPercentage) {

        let totalValue;

        totalValue = amount + Tax.computeIva(amount, taxPercentage);

        return totalValue;
    }
}

module.exports = Tax;