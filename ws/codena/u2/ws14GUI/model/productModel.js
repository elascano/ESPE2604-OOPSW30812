class Product {
    constructor(name, id, price, weightLb) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.weightLb = weightLb;
    }

    getWeightKg() {
        return (this.weightLb * 0.453592).toFixed(2);
    }
}

module.exports = Product;