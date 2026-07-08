const FarmAnimal = require("./FarmAnimal");
const IMeat = require("../interfaces/IMeat");

class Pig extends FarmAnimal {

    constructor(id, breed, age, weight) {
        super(id, breed, age, weight);
    }

    getCuts() {
        return [
            "Ham",
            "Bacon",
            "Loin",
            "Shoulder"
        ];
    }

    oink() {
        console.log("Oink!");
    }

}

Object.assign(Pig.prototype, IMeat.prototype);

module.exports = Pig;