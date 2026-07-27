import FarmAnimal from "./FarmAnimal.js";
import Cut from "./Cut.js"

export default class Cow extends FarmAnimal {
    constructor(id, breed, bornOnDate, weight, slaughterHouse, product, cuts, isProducingMilk, quantityOfMilk) {
        super(id, breed, bornOnDate, weight, slaughterHouse, product, cuts)
        this.isProducingMilk = isProducingMilk;
        this.quantityOfMilk = quantityOfMilk;
    }

    feed(food) {
        console.log(`Feeding the cow with ${food}`)
    }

    cut() {
        let cuts = [];

        if (this.slaughterHouse == null || this.slaughterHouse.name == null) {
            console.log("First send the Cow to slaughterHouse");

        } else {

            cuts.push(new Cut(1, "Brisket", "Cow", 13.5));
            cuts.push(new Cut(2, "Rib", "Cow", 34));
            cuts.push(new Cut(3, "Loin", "Cow", 58));
            cuts.push(new Cut(4, "Chuck", "Cow", 88));

            console.log("Cow has been cut");

            for (const cut of cuts) {
                console.log(cut.description);
            }
        }

        return cuts;
    }

    sendToSlaughterHouse(slaughterHouse) {

        if (this.isProducingMilk) {
            console.log("The Cow is producing milk, it cannot be sent to slaughterHouse");

        } else {
            this.slaughterHouse = slaughterHouse;
            console.log(`The Cow has been sent to SlaughterHouse ${slaughterHouse.name}`);
        }
    }

    milk() {
        let milkProduced = this.weight / 100;
        return milkProduced;
    }

    produce(productId) {

        if (this.isProducingMilk) {

            this.product.id = productId;
            this.product.description = "Milk";
            this.product.unit = "L";
            this.product.quantity = this.milk();

            console.log(`The cow produced ${this.product.quantity} ${this.product.unit} of ${this.product.description}`);

        } else {
            console.log("The cow cannot produce milk");
        }

        return this.product;
    }

    measureQuantity(unit, quantity) {

        if (this.isProducingMilk) {

            this.product.unit = unit;
            this.product.quantity = quantity;

            this.quantityOfMilk += quantity;

            console.log(`Measure: ${quantity} ${unit} of milk.`);

        } else {
            console.log("The cow is not producing milk");
        }
    }
}