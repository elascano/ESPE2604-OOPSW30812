import { FarmAnimal } from "./FarmAnimal.js";
import { Cut } from "./Cut.js";

export class Cow extends FarmAnimal {
    constructor(id, breed, bornOn, weight, isProducingMilk, milkAmount) {
        super(id, breed, bornOn, weight);
        this.isProducingMilk = isProducingMilk;
        this.milkAmount = milkAmount;
    }

    milk() {
        return this.milkAmount;
    }

    getAgeInMonths() {
        return super.getAgeInMonths();
    }

    cut() {
        return [
            new Cut(10, "T-Bone", "Rib Section", 5.5),
            new Cut(11, "Ribeye", "Loin Section", 3.8)
        ];
    }

    sendToSlaughterHouse(slaughterhouse) {
        console.log(`Cow ${this.id} sent to ${slaughterhouse.description}`);
    }
}