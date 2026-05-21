class Product {

    constructor(id, name, category, price) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    calculateSubtotal(quantity) {
        return this.price * quantity;
    }

    calculateTax(subtotal) {
        return subtotal * 0.12;
    }

    calculateTotal(subtotal, tax) {
        return subtotal + tax;
    }
}

module.exports = Product;
