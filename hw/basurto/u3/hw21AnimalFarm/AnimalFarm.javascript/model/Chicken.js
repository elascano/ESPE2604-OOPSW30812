import { FarmAnimal } from "./FarmAnimal.js";

export class Chicken extends FarmAnimal {
    constructor(id, breed, bornOn, weight, isMolting, numberOfEggsPerWeek) {
        super(id, breed, bornOn, weight);
        this.isMolting = isMolting;
        this.numberOfEggsPerWeek = numberOfEggsPerWeek;
    }

    layAnEgg() {
        console.log(`Chicken ${this.id} laid an egg.`);
    }

    operation() {
        console.log("Chicken operation executed.");
    }
}