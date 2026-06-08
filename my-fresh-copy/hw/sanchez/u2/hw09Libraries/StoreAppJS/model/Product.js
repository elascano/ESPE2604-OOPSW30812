
//author Joel Sanchez <The_Softwarriors at ESPE> 

const Tax = require('taxeslib');

class Product {
    constructor(id, description, price, pvp = null) {
        this._id = id;
        this._description = description;
        this._price = price;
        
        if (pvp === null) {
            this._pvp = Tax.computeTotal(price, 15.0);
        } else {
            this._pvp = pvp;
        }
    }

    toString() {
        return `Product\n{id=${this._id}\n description=${this._description}\n price=${this._price}\n pvp=${this._pvp}}`;
    }

    // Getters
    getId() {
        return this._id;
    }

    getDescription() {
        return this._description;
    }

    getPrice() {
        return this._price;
    }

    getPvp() {
        return this._pvp;
    }

    // Setters
    setId(id) {
        this._id = id;
    }

    setDescription(description) {
        this._description = description;
    }

    setPrice(price) {
        this._price = price;
    }

    setPvp(pvp) {
        this._pvp = pvp;
    }
}

module.exports = Product;