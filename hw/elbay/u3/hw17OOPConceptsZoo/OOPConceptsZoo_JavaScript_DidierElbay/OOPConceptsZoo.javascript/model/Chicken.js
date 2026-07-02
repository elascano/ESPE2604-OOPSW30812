/**
 * Chicken - Represents a chicken in the farm.
 * @author Didier Elbay
 */
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

    /**
     * Evaluates and prints the chicken's production status.
     */
    operation() {
        if (!this.isMolting && this.numberOfEggsPerWeek > 2) {
            console.log(`Chicken ${this.id}: Optimal Production.`);
        } else {
            console.log(`Chicken ${this.id}: Low Efficiency.`);
        }
    }
}
