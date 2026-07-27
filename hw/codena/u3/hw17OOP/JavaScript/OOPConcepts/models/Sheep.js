const FarmAnimal = require("./FarmAnimal");

class Sheep extends FarmAnimal {

    constructor(id, breed, bornOnDate, weight, lastShearing) {
        super(id, breed, bornOnDate, weight);
        this.lastShearing = lastShearing;
    }

    feed(food) {

        const typeOfFood = food.typeOfFood;

        const canFeed = typeOfFood === "Grass" || typeOfFood === "Hay";

        if (canFeed) {
            this.weight++;
        }

        return canFeed;

    }

    toDocument() {

        return {
            _id: this.id,
            type: "Sheep",
            breed: this.breed,
            bornOnDate: new Date(this.bornOnDate),
            weight: this.weight,
            lastShearing: new Date(this.lastShearing)
        };

    }

}

module.exports = Sheep;