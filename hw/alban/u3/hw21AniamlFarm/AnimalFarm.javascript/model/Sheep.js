import { FarmAnimal } from "./FarmAnimal.js";

export class Sheep extends FarmAnimal {
    constructor(id, breed, bornOn, weight, lastSheering) {
        super(id, breed, bornOn, weight);
        this.lastSheering = lastSheering;
    }
}