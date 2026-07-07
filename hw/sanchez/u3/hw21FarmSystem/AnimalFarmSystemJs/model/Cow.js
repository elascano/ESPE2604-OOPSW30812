const FarmAnimal = require('./FarmAnimal');
const Product = require('./Product');
const Cut = require('./Cut');

class Cow extends FarmAnimal {
    constructor(producingMilk, id, breed, bornOn, weight, slaughterHouse, product, cuts) {
        super(id, breed, bornOn, weight, slaughterHouse, product, cuts);
        this.producingMilk = producingMilk;
    }

    milk() {
        if (this.producingMilk) {
            return 15.5;
        }
        return 0;
    }

    isProducingMilk() {
        return this.producingMilk;
    }

    feed(food) {
        this.setWeight(this.getWeight() + 0.5);
    }

    cut() {
        const cuts = [];
        cuts.push(new Cut(1, "T-Bone Steak", "Cut from the short loin", 2.5));
        cuts.push(new Cut(2, "Ribeye", "Cut from the rib section", 3.0));
        cuts.push(new Cut(3, "Sirloin", "Cut from the rear back", 4.0));
        cuts.push(new Cut(4, "Round", "Cut from the hind leg", 5.0));
        this.setCuts(cuts);
        return cuts;
    }

    sendToSlaughterHouse(slaughterHouse) {
        this.slaughterHouse = slaughterHouse;
    }

    produce() {
        if (this.producingMilk) {
            const milk = new Product(101, "Cow Milk", "Liters", this.milk());
            this.setProduct(milk);
            return milk;
        }
        return null;
    }

    measureQuantity(unit, quantity) {
        if (this.getProduct() !== null) {
            this.getProduct().setUnit(unit);
            this.getProduct().setQuantity(quantity);
        }
    }

    setProducingMilk(producingMilk) {
        this.producingMilk = producingMilk;
    }
}

module.exports = Cow;