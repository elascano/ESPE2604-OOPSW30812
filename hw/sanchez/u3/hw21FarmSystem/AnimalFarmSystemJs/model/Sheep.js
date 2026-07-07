const FarmAnimal = require('./FarmAnimal');
const Product = require('./Product');
const Cut = require('./Cut');

class Sheep extends FarmAnimal {
    constructor(lastSheering, kgOfWool, id, breed, bornOn, weight, slaughterHouse, product, cuts) {
        super(id, breed, bornOn, weight, slaughterHouse, product, cuts);
        this.lastSheering = lastSheering;
        this.kgOfWool = kgOfWool;
    }

    shear() {
        this.lastSheering = new Date();
        return this.kgOfWool;
    }

    feed(food) {
        this.setWeight(this.getWeight() + 0.3);
    }

    cut() {
        const cuts = [];
        cuts.push(new Cut(1, "Rack", "Cut from the rib", 1.5));
        cuts.push(new Cut(2, "Leg", "Cut from the hind leg", 2.0));
        cuts.push(new Cut(3, "Shoulder", "Cut from the front leg", 1.8));
        cuts.push(new Cut(4, "Chop", "Cut from the loin", 1.2));
        this.setCuts(cuts);
        return cuts;
    }

    sendToSlaughterHouse(slaughterHouse) {
        this.slaughterHouse = slaughterHouse;
    }

    produce() {
        const wool = new Product(301, "Sheep Wool", "Kilograms", this.kgOfWool);
        this.setProduct(wool);
        return wool;
    }

    measureQuantity(unit, quantity) {
        if (this.getProduct() !== null) {
            this.getProduct().setUnit(unit);
            this.getProduct().setQuantity(quantity);
        }
    }

    getLastSheering() { return this.lastSheering; }
    setLastSheering(lastSheering) { this.lastSheering = lastSheering; }
    getKgOfWool() { return this.kgOfWool; }
    setKgOfWool(kgOfWool) { this.kgOfWool = kgOfWool; }
}

module.exports = Sheep;