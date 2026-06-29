const FarmAnimal = require("./farmAnimal");

class Cow extends FarmAnimal {

    constructor(id, breed, weight) {
        super(id, breed, weight);
    }

    born() {
        console.log("A calf was born.");
    }

}

module.exports = Cow;