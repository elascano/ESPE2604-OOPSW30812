const FarmAnimal = require("./farmAnimal");

class Chicken extends FarmAnimal {

    constructor(id, breed, weight) {
        super(id, breed, weight);
    }

    born() {
        console.log("A chick was born.");
    }

}

module.exports = Chicken;