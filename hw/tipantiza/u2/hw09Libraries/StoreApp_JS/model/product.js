const Tax = require('taxeslib');

class Product {
    constructor(identificationNumber, description, basePrice, publicSalePrice = null) {
        this.identificationNumber = identificationNumber;
        this.description = description;
        this.basePrice = basePrice;
        
        if (publicSalePrice === null) {
            const defaultTaxPercentage = 15;
            this.publicSalePrice = Tax.computeTotalWithTax(basePrice, defaultTaxPercentage);
        } else {
            this.publicSalePrice = publicSalePrice;
        }
    }

    toString() {
        return `Product [\n` +
               `  Identification Number: ${this.identificationNumber}\n` +
               `  Description: ${this.description}\n` +
               `  Base Price: $${this.basePrice.toFixed(2)}\n` +
               `  Public Sale Price: $${this.publicSalePrice.toFixed(2)}\n` +
               `]`;
    }
}

module.exports = Product;