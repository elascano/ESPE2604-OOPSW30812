const FarmAnimal = require('./FarmAnimal');
const Product = require('./Product');
const Cut = require('./Cut');

class Chicken extends FarmAnimal {
    constructor(isMolting, numberOfEggsPerWeek, id, breed, bornOn, weight, slaughterHouse, product, cuts) {
        super(id, breed, bornOn, weight, slaughterHouse, product, cuts);
        this.isMolting = isMolting;
        this.numberOfEggsPerWeek = numberOfEggsPerWeek;
    }

    layAnEgg() {
        if (!this.isMolting) {
            this.numberOfEggsPerWeek++;
            return true;
        }
        return false;
    }

    feed(food) {
        this.setWeight(this.getWeight() + 0.1);
    }

    cut() {
        const cuts = [];
        cuts.push(new Cut(1, "Breast", "Cut from the chest", 0.5));
        cuts.push(new Cut(2, "Thigh", "Cut from the leg", 0.3));
        cuts.push(new Cut(3, "Wing", "Cut from the wing", 0.2));
        cuts.push(new Cut(4, "Drumstick", "Cut from the lower leg", 0.25));
        this.setCuts(cuts);
        return cuts;
    }

    sendToSlaughterHouse(slaughterHouse) {
        this.slaughterHouse = slaughterHouse;
    }

    produce() {
        const eggs = new Product(201, "Chicken Eggs", "Units", this.numberOfEggsPerWeek);
        this.setProduct(eggs);
        return eggs;
    }

    measureQuantity(unit, quantity) {
        if (this.getProduct() !== null) {
            this.getProduct().setUnit(unit);
            this.getProduct().setQuantity(quantity);
        }
    }

    isIsMolting() { return this.isMolting; }
    setIsMolting(isMolting) { this.isMolting = isMolting; }
    getNumberOfEggsPerWeek() { return this.numberOfEggsPerWeek; }
    setNumberOfEggsPerWeek(numberOfEggsPerWeek) { this.numberOfEggsPerWeek = numberOfEggsPerWeek; }
}

module.exports = Chicken;