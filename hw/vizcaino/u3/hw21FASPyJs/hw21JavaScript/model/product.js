export class Product {
    constructor(id, description, unit, quantity) {
        this.id = id;
        this.description = description;
        this.unit = unit;
        this.quantity = quantity;
    }

    toString() {
        return `Product{id=${this.id}, description=${this.description}, unit=${this.unit}, quantity=${this.quantity}}`;
    }
}