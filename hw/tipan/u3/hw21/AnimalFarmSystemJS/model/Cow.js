const FarmAnimal = require("./FarmAnimal");
class Cow extends FarmAnimal {

    constructor(productionInLiters, quality,
        id, breed, bornOn, weight,
        slaughterHouse, product, cuts) {

        super(id, breed, bornOn, weight,
            slaughterHouse, product, cuts);

        this.productionInLiters = productionInLiters;
        this.quality = quality;
    }

    feed(food) {
        console.log(`Feeding the cow with ${food.toString()} and grass`);
    }

    produce() {
        return this.product;
    }

    measureQuantity(unit, quantity) {
        console.log(`Production: ${quantity} ${unit}`);
    }
}

module.exports = Cow;