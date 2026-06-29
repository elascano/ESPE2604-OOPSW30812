const FarmAnimal = require("./farmAnimal");

class Pig extends FarmAnimal {

    constructor(id, breed, weight) {
        super(id, breed, weight);
    }

    born() {
        console.log("A piglet was born.");
    }

}

module.exports = Pig;