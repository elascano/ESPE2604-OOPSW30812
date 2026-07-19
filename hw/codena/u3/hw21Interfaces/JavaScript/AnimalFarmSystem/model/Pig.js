import FarmAnimal from "./FarmAnimal.js";
import Cut from "./Cut.js"

export default class Pig extends FarmAnimal {
    constructor(id, breed, bornOnDate, weight, slaughterHouse, product, cuts, idealWeight) {
        super(id, breed, bornOnDate, weight, slaughterHouse, product, cuts)
        this.idealWeight = idealWeight
    }

    feed(food) {
        console.log(`Feeding the Pig with ${food} in a bowl and water`)
    }

    cut() {
        let cuts = [];

        if (this.slaughterHouse == null || this.slaughterHouse.name == null) {
            console.log("First send the Pig to slaughterHouse");

        } else {

            cuts.push(new Cut(1, "Ham", "Pig", 20));
            cuts.push(new Cut(2, "Loin", "Pig", 16));
            cuts.push(new Cut(3, "Belly", "Pig", 16.5));
            cuts.push(new Cut(4, "Feet", "Pig", 5));

            console.log("Pig has been cut");

            for (const cut of cuts) {
                console.log(cut.description);
            }
        }

        return cuts;
    }

    sendToSlaughterHouse(slaughterHouse) {

        if (this.weight >= this.idealWeight) {
            this.slaughterHouse = slaughterHouse;
            console.log(`Pig has been sent to SlaughterHouse  ${slaughterHouse.name}`);

        } else {
            console.log("Pig has not reached the ideal weight, it was not sent to slaughterhouse");
        }
    }

    milk() {
        let milkProduced = this.weight / 100;
        return milkProduced;
    }

}
