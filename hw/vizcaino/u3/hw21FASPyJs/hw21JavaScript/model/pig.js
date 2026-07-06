import { FarmAnimal } from "./farmAnimal.js";
import { Cut } from "./cut.js";

export class Pig extends FarmAnimal {
    constructor(
        idealWeight,
        premiumCutsPercentage,
        id,
        breed,
        bornOn,
        weight,
        slaughterHouse,
        product,
        cuts
    ) {
        super(
            id,
            breed,
            bornOn,
            weight,
            slaughterHouse,
            product,
            cuts
        );

        this.idealWeight = idealWeight;
        this.premiumCutsPercentage = premiumCutsPercentage;
    }

    isReadyForSlaughter() {
        return this.weight >= this.idealWeight;
    }

    calculatePremiumCuts() {
        return (
            this.weight *
            this.premiumCutsPercentage
        ) / 100;
    }

    sendToSlaughterHouse(slaughterHouse) {
        this.slaughterHouse = slaughterHouse;
    }

    feed(food) {
        throw new Error("Method not implemented");
    }

    cut() {
        const estimatedCutWeight =
            this.weight / 4;

        this.cuts = [
            new Cut(
                1,
                "Pork Loin",
                "Back section, lean meat cut",
                estimatedCutWeight
            ),
            new Cut(
                2,
                "Spare Ribs",
                "Lower rib cage section",
                estimatedCutWeight
            ),
            new Cut(
                3,
                "Pork Belly",
                "Fatty boneless cut from the abdomen",
                estimatedCutWeight
            ),
            new Cut(
                4,
                "Boston Butt",
                "Upper shoulder section cut",
                estimatedCutWeight
            )
        ];

        return this.cuts;
    }

    toString() {
        return `Pig{${super.toString()}, idealWeight=${this.idealWeight}, premiumCutsPercentage=${this.premiumCutsPercentage}}`;
    }
}