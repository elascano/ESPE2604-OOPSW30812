const FarmAnimal = require("./farmAnimal");

class Sheep extends FarmAnimal {

    constructor(id, breed, weight) {
        super(id, breed, weight);
    }

    born() {
        console.log("A lamb was born.");
    }

}

module.exports = Sheep;