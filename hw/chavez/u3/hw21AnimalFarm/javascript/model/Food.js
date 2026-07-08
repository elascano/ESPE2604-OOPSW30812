class Food {

    constructor(name, quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    toString() {
        return `${this.quantity} kg of ${this.name}`;
    }

}

module.exports = Food;