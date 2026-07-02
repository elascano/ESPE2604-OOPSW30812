/**
 * FarmAnimal - Base class for all farm animals.
 * @author Didier Elbay
 */
export class FarmAnimal {
    constructor(id, breed, bornOn, weight) {
        this.id = id;
        this.breed = breed;
        this.bornOn = bornOn;   // Expected: Date object
        this.weight = weight;
    }

    /**
     * Returns the animal's age in months, calculated from bornOn.
     */
    getAgeInMonths() {
        const today = new Date();
        const months =
            (today.getFullYear() - this.bornOn.getFullYear()) * 12 +
            (today.getMonth() - this.bornOn.getMonth());
        return Math.max(0, months);
    }

    feed(food) {
        console.log(`Animal ${this.id} is eating ${food.description}`);
    }
}
