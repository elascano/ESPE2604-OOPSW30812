class Vehicle {

    constructor(id, description, value, quantity) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.quantity = quantity;
    }

    calculateTotalValue() {
        return this.value * this.quantity;
    }
}

module.exports = Vehicle;