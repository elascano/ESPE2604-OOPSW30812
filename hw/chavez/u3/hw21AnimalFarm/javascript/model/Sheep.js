const FarmAnimal = require("./FarmAnimal");
const IProduce = require("../interfaces/IProduce");
const IMeat = require("../interfaces/IMeat");

class Sheep extends FarmAnimal {

    constructor(id, breed, age, weight, woolWeight) {
        super(id, breed, age, weight);
        this.woolWeight = woolWeight;
    }

    produce() {
        return `${this.woolWeight} kg of wool`;
    }

    getCuts() {
        return [
            "Leg",
            "Loin",
            "Rack",
            "Shoulder"
        ];
    }

    bleat() {
        console.log("Baa!");
    }

}

Object.assign(Sheep.prototype, IProduce.prototype);
Object.assign(Sheep.prototype, IMeat.prototype);

module.exports = Sheep;