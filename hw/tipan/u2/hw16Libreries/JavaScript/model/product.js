const Tax = require("../utils/tax");

class Product {

    constructor(id, description, price, pvp = null) {

        this.id = id;
        this.description = description;
        this.price = price;

        if (pvp === null) {
            this.pvp = Tax.computeTotal(price, 15);
        } else {
            this.pvp = pvp;
        }
    }

    toString() {

        return `Product(id=${this.id}, description=${this.description}, price=${this.price}, pvp=${this.pvp})`;
    }
}

module.exports = Product;