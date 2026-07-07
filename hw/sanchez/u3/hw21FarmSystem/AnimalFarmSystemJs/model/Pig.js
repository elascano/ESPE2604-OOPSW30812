const FarmAnimal = require('./FarmAnimal');
const Cut = require('./Cut');

class Pig extends FarmAnimal {
    constructor(idealWeight, id, breed, bornOn, weight, slaughterHouse, product, cuts) {
        super(id, breed, bornOn, weight, slaughterHouse, product, cuts);
        this.idealWeight = idealWeight;
    }

    feed(food) {
        this.setWeight(this.getWeight() + 0.8);
    }

    cut() {
        const cuts = [];
        cuts.push(new Cut(1, "Pork Chop", "Cut from the loin", 2.0));
        cuts.push(new Cut(2, "Bacon", "Cut from the belly", 3.0));
        cuts.push(new Cut(3, "Ham", "Cut from the hind leg", 4.0));
        cuts.push(new Cut(4, "Shoulder", "Cut from the front leg", 4.5));
        this.setCuts(cuts);
        return cuts;
    }

    sendToSlaughterHouse(slaughterHouse) {
        this.slaughterHouse = slaughterHouse;
    }

    getIdealWeight() { return this.idealWeight; }
    setIdealWeight(idealWeight) { this.idealWeight = idealWeight; }
}

module.exports = Pig;