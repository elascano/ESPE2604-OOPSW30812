class FarmAnimal {

    constructor(id, breed, weight) {
        this.id = id;
        this.breed = breed;
        this.weight = weight;
    }

    feed(food) {
        console.log(`${this.breed} is eating ${food.description}`);
    }

    getAgeInMonths() {
        return 1;
    }

    // Business Rule 1
    isYoungAnimal() {
        return this.weight < 100;
    }

    // Business Rule 2
    isReadyForSale() {
        return this.weight >= 300;
    }

    // Business Rule 3
    needsMoreFood() {
        return this.weight < 50;
    }

    born() {
        throw new Error("This method must be overridden.");
    }
}

module.exports = FarmAnimal;