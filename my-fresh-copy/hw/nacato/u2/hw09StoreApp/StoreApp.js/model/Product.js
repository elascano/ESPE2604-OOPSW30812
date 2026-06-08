const Tax = require('../libraries/Tax');

class Product {
    #id;
    #description;
    #price;
    #pvp;

    constructor(id, description, price, pvp = null) {
        this.#id = id;
        this.#description = description;
        this.#price = price;

        if (pvp === null) {
            // TODO compute total price
            this.#pvp = Tax.computeTotal(price, 15.0);
        } else {
            this.#pvp = pvp;
        }
    }

    get id() { return this.#id; }
    set id(id) { this.#id = id; }

    get description() { return this.#description; }
    set description(description) { this.#description = description; }

    get price() { return this.#price; }
    set price(price) { this.#price = price; }

    get pvp() { return this.#pvp; }
    set pvp(pvp) { this.#pvp = pvp; }

    toString() {
        return `Product\n{id=${this.#id}, description=${this.#description}, price=${this.#price}, pvp=${this.#pvp}}`;
    }
}

module.exports = Product;