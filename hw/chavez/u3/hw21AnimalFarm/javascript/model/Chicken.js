const FarmAnimal = require("./FarmAnimal");
const IProduce = require("../interfaces/IProduce");

class Chicken extends FarmAnimal {

    constructor(id, breed, age, weight, eggsPerWeek) {
        super(id, breed, age, weight);
        this.eggsPerWeek = eggsPerWeek;
    }

    produce() {
        return `${this.eggsPerWeek} eggs per week`;
    }

    cluck() {
        console.log("Cluck! Cluck!");
    }

}

Object.assign(Chicken.prototype, IProduce.prototype);

module.exports = Chicken;