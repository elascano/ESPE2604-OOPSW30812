const FarmAnimal = require('./farmAnimal');
const { Cut } = require('./infrastructure');

class Pig extends FarmAnimal {
    constructor(id, breed, bornOn, weight, idealWeight) {
        super(id, breed, bornOn, weight);
        this._idealWeight = idealWeight;
    }

    cut() {
        this.cuts = [new Cut(1, "Pork Chop", "Primal cut", this._weight * 0.2)];
        return this.cuts;
    }

    sendToSlaughterHouse(slaughterHouse) {
        this.slaughterHouse = slaughterHouse._name;
    }
}

class Cow extends FarmAnimal {
    constructor(id, breed, bornOn, weight, isProducingMilk) {
        super(id, breed, bornOn, weight);
        this._isProducingMilk = isProducingMilk;
    }

    isProducingMilkStatus() {
        return this._isProducingMilk;
    }

    milk() {
        return this._isProducingMilk ? 15.5 : 0.0;
    }

    cut() {
        this.cuts = [new Cut(2, "Lomo Fino", "Rear cut", this._weight * 0.15)];
        return this.cuts;
    }

    sendToSlaughterHouse(slaughterHouse) {
        this.slaughterHouse = slaughterHouse._name;
    }
}

module.exports = { Pig, Cow };