import { FarmAnimal } from "./farmAnimal.js";
import { Cut } from "./cut.js";
import { Product } from "./product.js";

export class Cow extends FarmAnimal {
    constructor(
        producingMilk,
        carcassYield,
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

        this.producingMilk = producingMilk;
        this.carcassYield = carcassYield;
    }

    milk() {
        return this.producingMilk ? 15.5 : 0.0;
    }

    calculateMeatYield() {
        return (this.weight * this.carcassYield) / 100;
    }

    cut() {
        const estimatedCutWeight =
            this.calculateMeatYield() / 4;

        this.cuts = [
            new Cut(
                1,
                "Tenderloin",
                "Tender cut from the upper spine",
                estimatedCutWeight
            ),
            new Cut(
                2,
                "Ribeye",
                "Marbled rib section cut",
                estimatedCutWeight
            ),
            new Cut(
                3,
                "Ribs",
                "Bony section from the chest",
                estimatedCutWeight
            ),
            new Cut(
                4,
                "Flank Steak",
                "Transverse cut from the abdominal muscles",
                estimatedCutWeight
            )
        ];

        return this.cuts;
    }

    sendToSlaughterHouse(slaughterHouse) {
        this.slaughterHouse = slaughterHouse;
    }

    produce() {
        if (this.producingMilk) {
            if (!this.product) {
                this.product = new Product(
                    101,
                    "Whole Milk",
                    "Liters",
                    0
                );
            }

            return this.product;
        }

        return null;
    }

    measureQuantity(unit, quantity) {
        const currentProduct = this.produce();

        if (currentProduct) {
            currentProduct.unit = unit;
            currentProduct.quantity = quantity;
        }
    }

    feed(food) {
        throw new Error("Method not implemented");
    }

    toString() {
        return `Cow{${super.toString()}, producingMilk=${this.producingMilk}, carcassYield=${this.carcassYield}}`;
    }
}