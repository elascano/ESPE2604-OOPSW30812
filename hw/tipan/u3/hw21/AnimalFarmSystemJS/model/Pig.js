const FarmAnimal = require("./FarmAnimal");
class Pig extends FarmAnimal {

    constructor(idealWeight, id, breed, bornOn, weight, slaughterHouse, product, cuts) {
        super(id, breed, bornOn, weight, slaughterHouse, product, cuts);

        this.idealWeight = idealWeight;
    }

    feed(food) {
        console.log(`Feeding THE PIG with food --> ${food.toString()} in a bowl and water`);
    }

    cut() {
        return [];
    }

    sendToSlaughterHouse(slaughterHouse) {
        this.slaughterHouse = slaughterHouse;
    }

    isReadyForSlaughter() {
        return this.weight >= this.idealWeight;
    }
}

module.exports = Pig;