/**
 * Cow - Represents a cow in the farm. Implements the IMeatAnimal contract.
 * @author Didier Elbay
 */
import { FarmAnimal } from "./FarmAnimal.js";
import { IMeatAnimal } from "../controller/IMeatAnimal.js";
import { Cut } from "./Cut.js";

export class Cow extends FarmAnimal {
    constructor(id, breed, bornOn, weight, isProducingMilk, milkAmount) {
        super(id, breed, bornOn, weight);
        this.isProducingMilk = isProducingMilk;
        this.milkAmount = milkAmount;
    }

    getMilkProduction() {
        return this.milkAmount;
    }

    /**
     * Returns milk efficiency as a percentage relative to body weight.
     */
    getMilkEfficiency() {
        if (this.weight <= 0) return 0;
        return ((this.milkAmount / this.weight) * 100).toFixed(1);
    }

    // IMeatAnimal contract
    cut() {
        return [
            new Cut(10, "T-Bone",  "Rib Section",  parseFloat((this.weight * 0.20).toFixed(2))),
            new Cut(11, "Ribeye",  "Loin Section", parseFloat((this.weight * 0.12).toFixed(2))),
        ];
    }

    sendToSlaughterHouse(slaughterhouse) {
        console.log(`Cow ${this.id} sent to ${slaughterhouse.description}`);
    }
}
