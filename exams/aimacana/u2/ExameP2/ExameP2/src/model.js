export class Furniture {
    constructor(id, name, price, quantity) {
        this.id = id;
        this.name = name;
        this.price = parseFloat(price);
        this.quantity = parseInt(quantity);
    }

    calculateInventoryValue() {
        return this.price * this.quantity;
    }
}
