/**
 * Pig - Represents a pig in the farm. Implements the IMeatAnimal contract.
 * @author Didier Elbay
 */
import { FarmAnimal } from "./FarmAnimal.js";
import { IMeatAnimal } from "../controller/IMeatAnimal.js";
import { Cut } from "./Cut.js";

export class Pig extends FarmAnimal {
    constructor(id, breed, bornOn, weight, idealWeight) {
        super(id, breed, bornOn, weight);
        this.idealWeight = idealWeight;
    }

    isReadyForSlaughter() {
        return this.weight >= this.idealWeight;
    }

    sendToButcher() {
        console.log(`Pig ${this.id} sent to butcher.`);
    }

    // IMeatAnimal contract
    cut() {
        return [
            new Cut(1, "Pork Chop", "Standard Cut",   parseFloat((this.weight * 0.15).toFixed(2))),
            new Cut(2, "Ribs",      "Rib Extraction",  parseFloat((this.weight * 0.10).toFixed(2))),
        ];
    }

    sendToSlaughterHouse(slaughterhouse) {
        console.log(`Pig ${this.id} sent to ${slaughterhouse.description}`);
    }
}
