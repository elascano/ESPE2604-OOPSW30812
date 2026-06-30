const FarmAnimal = require("./FarmAnimal");
const Cut = require("./Cut");

class Cow extends FarmAnimal {

    constructor(id, breed, bornOnDate, weight, isProducingMilk) {
        super(id, breed, bornOnDate, weight);
        this.isProducingMilk = isProducingMilk;

    }

    milk() {
        let quantityOfMilk;

        if (this.isProducingMilk) {
            quantityOfMilk = this.weight / 100;
        } else {
            quantityOfMilk = 0;
        }

        return quantityOfMilk;

    }

    feed(food) {

        const typeOfFood = food.typeOfFood;

        const canFeed = typeOfFood === "Grass" || typeOfFood === "Hay";

        if (canFeed) {
            this.weight++;
        }

        return canFeed;

    }

    cut() {
        const cuts = [];

        cuts.push(new Cut(this.id, "Steak", "Cow", 25.0));
        cuts.push(new Cut(this.id, "Ribs", "Cow", 12.5));
        cuts.push(new Cut(this.id, "Ground Beef", "Cow", 18.0));

        return cuts;

    }

    toDocument() {

        return {
            _id: this.id,
            type: "Cow",
            breed: this.breed,
            bornOnDate: new Date(this.bornOnDate),
            weight: this.weight,
            isProducingMilk: this.isProducingMilk
        };

    }

}

module.exports = Cow;