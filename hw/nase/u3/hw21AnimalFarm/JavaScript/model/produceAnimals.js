const FarmAnimal = require('./farmAnimal');
const { Product } = require('./infrastructure');

class Chicken extends FarmAnimal {
    constructor(id, breed, bornOn, weight, isMolting, numberOfEggsPerWeek) {
        super(id, breed, bornOn, weight);
        this._isMolting = isMolting;
        this._numberOfEggsPerWeek = numberOfEggsPerWeek;
    }

    layAnEgg() {
        return !this._isMolting 
            ? "The hen has successfully laid an egg.." 
            : "The hen is molting; she cannot lay eggs at the moment..";
    }

    procedure() {
        return "Manual egg collection in the poultry house.";
    }

    measureQuantity(unit, quantity) {
        this.product = new Product(101, "Free-range eggs", unit, quantity);
    }
}

class Sheep extends FarmAnimal {
    constructor(id, breed, bornOn, weight, lastSheering) {
        super(id, breed, bornOn, weight);
        this._lastSheering = new Date(lastSheering);
    }

    procedure() {
        return "Mechanical shearing of fine wool.";
    }

    measureQuantity(unit, quantity) {
        this.product = new Product(102, "Lana de Oveja", unit, quantity);
    }
}

module.exports = { Chicken, Sheep };