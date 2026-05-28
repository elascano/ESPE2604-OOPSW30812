class Tax {

    static computeIva(amount, taxPercentage) {
        return amount * taxPercentage / 100;
    }

    static computeTotal(amount, taxPercentage) {
        return amount + Tax.computeIva(amount, taxPercentage);
    }
}

module.exports = Tax;