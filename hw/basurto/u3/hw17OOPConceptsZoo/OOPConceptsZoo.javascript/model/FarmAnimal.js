export class FarmAnimal {
    constructor(id, breed, bornOn, weight) {
        this.id = id;
        this.breed = breed;
        this.bornOn = bornOn;
        this.weight = weight;
    }

    getAgeInMonths() {
        return 1;
    }

    feed(food) {
        console.log(`Animal ${this.id} is eating ${food.description}`);
    }
}