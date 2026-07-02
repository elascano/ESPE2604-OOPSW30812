const FarmAnimal = require("./FarmAnimal");

class Chicken extends FarmAnimal {

    constructor(id, breed, bornOnDate, weight, isMolting, numberOfEggs) {
        super(id, breed, bornOnDate, weight);
        this.isMolting = isMolting;
        this.numberOfEggs = numberOfEggs;

    }

    layAnEgg() {

        if (!this.isMolting) {
            this.numberOfEggs++;
        }

        return this.isMolting;

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
            type: "Chicken",
            breed: this.breed,
            bornOnDate: new Date(this.bornOnDate),
            weight: this.weight,
            isMolting: this.isMolting,
            numberOfEggs: this.numberOfEggs
        };

    }

}

module.exports = Chicken;