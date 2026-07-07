class Product {
    constructor(id, description, unit, quantity) {
        this.id = id;
        this.description = description;
        this.unit = unit;
        this.quantity = quantity;
    }

    getId() { return this.id; }
    setId(id) { this.id = id; }
    getDescription() { return this.description; }
    setDescription(description) { this.description = description; }
    getUnit() { return this.unit; }
    setUnit(unit) { this.unit = unit; }
    getQuantity() { return this.quantity; }
    setQuantity(quantity) { this.quantity = quantity; }
}

module.exports = Product;