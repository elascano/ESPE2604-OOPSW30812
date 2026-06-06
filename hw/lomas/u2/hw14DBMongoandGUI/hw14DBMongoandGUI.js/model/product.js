class Product {
    constructor(productId, name, price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    toDict() {
        return {
            _id: this.productId,
            name: this.name,
            price: this.price
        };
    }
}

module.exports = Product;