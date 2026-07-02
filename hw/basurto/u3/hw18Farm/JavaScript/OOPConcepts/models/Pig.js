const FarmAnimal = require("./FarmAnimal");
const Cut = require("./Cut");

class Pig extends FarmAnimal {

    constructor(id, breed, bornOnDate, weight, idealWeight) {
        super(id, breed, bornOnDate, weight);
        this.idealWeight = idealWeight;
    }

    sendToButcher() {
        return this.weight >= this.idealWeight;
    }

    cut() {
        const cuts = [];

        if (!this.sendToButcher()) {
            return cuts;
        }

        cuts.push(new Cut(this.id, "Ham", "Pig", 12.0));
        cuts.push(new Cut(this.id, "Bacon", "Pig", 8.0));
        cuts.push(new Cut(this.id, "Ribs", "Pig", 6.5));

        return cuts;

    }

    feed(food) {

        const typeOfFood = food.typeOfFood;

        const canFeed = typeOfFood === "Corn" || typeOfFood === "Mixed Feed";

        if (canFeed) {
            this.weight++;
        }

        return canFeed;

    }

    toDocument() {

        return {
            _id: this.id,
            type: "Pig",
            breed: this.breed,
            bornOnDate: new Date(this.bornOnDate),
            weight: this.weight,
            idealWeight: this.idealWeight
        };

    }

}

module.exports = Pig;