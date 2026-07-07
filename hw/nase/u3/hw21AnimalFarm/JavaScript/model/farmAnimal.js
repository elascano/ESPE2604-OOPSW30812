const { Food } = require('./infrastructure');

class FarmAnimal {
    constructor(id, breed, bornOn, weight) {
        if (this.constructor === FarmAnimal) {
        }
        this._id = id;
        this._breed = breed;
        this._bornOn = new Date(bornOn);
        this._weight = weight;

        this.cuts = [];
        this.product = null;
        this.slaughterHouse = null;
    }

    getAgeInMonths() {
        const today = new Date();
        const yearsDiff = today.getFullYear() - this._bornOn.getFullYear();
        const monthsDiff = today.getMonth() - this._bornOn.getMonth();
        return (yearsDiff * 12) + monthsDiff;
    }

    feed(food) {
        return `The purebred animal ${this._breed} has been fed with: ${food._description}`;
    }
}

module.exports = FarmAnimal;