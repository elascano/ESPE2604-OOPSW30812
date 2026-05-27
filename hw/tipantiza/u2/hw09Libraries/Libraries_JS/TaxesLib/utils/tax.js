class Tax {
    static computeValueAddedTax(basePrice, taxPercentage) {
        return (basePrice * taxPercentage) / 100;
    }

    static computeTotalWithTax(basePrice, taxPercentage) {
        const calculatedTax = Tax.computeValueAddedTax(basePrice, taxPercentage);
        return basePrice + calculatedTax;
    }
}

module.exports = Tax;