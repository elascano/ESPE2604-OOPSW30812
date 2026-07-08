class Product {

    constructor(id, name, price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    toString() {
        return `Product: ${this.name} - $${this.price}`;
    }

}

module.exports = Product;