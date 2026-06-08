
//author Joel Sanchez <The_Softwarriors at ESPE>

class Tax {
    static computeIva(amount, taxPercentage) {
        let taxValue = amount * taxPercentage / 100;
        return taxValue;
    }
    
    static computeTotal(amount, taxPercentage) {
        let totalValue = amount + Tax.computeIva(amount, taxPercentage);
        return totalValue;
    }
}

module.exports = Tax;