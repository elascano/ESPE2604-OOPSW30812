import { FarmAnimal } from "./FarmAnimal.js";
import { Cut } from "./Cut.js";

export class Pig extends FarmAnimal {
    constructor(id, breed, bornOn, weight, idealWeight) {
        super(id, breed, bornOn, weight);
        this.idealWeight = idealWeight;
    }

    sendToButcher() {
        console.log(`Pig ${this.id} sent to butcher.`);
    }

    cut() {
        return [
            new Cut(1, "Pork Chop", "Standard Cut", 2.5),
            new Cut(2, "Ribs", "Rib Extraction", 4.0)
        ];
    }

    sendToSlaughterHouse(slaughterhouse) {
        console.log(`Pig ${this.id} sent to ${slaughterhouse.description}`);
    }
}