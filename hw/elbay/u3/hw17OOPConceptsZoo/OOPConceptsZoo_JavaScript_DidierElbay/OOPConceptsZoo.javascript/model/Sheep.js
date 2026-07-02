/**
 * Sheep - Represents a sheep in the farm.
 * @author Didier Elbay
 */
import { FarmAnimal } from "./FarmAnimal.js";

export class Sheep extends FarmAnimal {
    constructor(id, breed, bornOn, weight, lastSheering) {
        super(id, breed, bornOn, weight);
        this.lastSheering = lastSheering;   // Expected: Date object
    }

    /**
     * Performs a shearing and updates the lastSheering date.
     */
    shear() {
        this.lastSheering = new Date();
        console.log(`Sheep ${this.id} has been sheared on ${this.lastSheering.toDateString()}.`);
    }

    /**
     * Returns true if the sheep is within the optimal weight for shearing.
     */
    isReadyForShearing() {
        return this.weight >= 45.0 && this.weight <= 80.0;
    }
}
