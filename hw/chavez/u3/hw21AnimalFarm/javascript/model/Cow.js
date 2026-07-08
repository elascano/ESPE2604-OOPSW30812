const FarmAnimal = require("./FarmAnimal");
const IProduce = require("../interfaces/IProduce");
const IMeat = require("../interfaces/IMeat");

class Cow extends FarmAnimal {

    constructor(id, breed, age, weight, dailyMilk) {
        super(id, breed, age, weight);
        this.dailyMilk = dailyMilk;
    }

    produce() {
        return `${this.dailyMilk} liters of milk`;
    }

    getCuts() {
        return [
            "Rib",
            "Tenderloin",
            "Sirloin",
            "Brisket"
        ];
    }

    moo() {
        console.log("Moo!");
    }

}

Object.assign(Cow.prototype, IProduce.prototype);
Object.assign(Cow.prototype, IMeat.prototype);

module.exports = Cow;