class Chicken extends FarmAnimal {
    constructor(id, breed, bornOnDate, weight, slaughterHouse, product, cuts, isMolting, numberOfEggs) {
        super(id, breed, bornOnDate, weight, slaughterHouse, product, cuts)
        this.isMolting = isMolting
        this.numberOfEggs = numberOfEggs
    }

    feed(food) {
        console.log(`Feeding the chicken with --> ${food}`)
    }

    layAnEgg() {
        if (this.isMolting) {
            console.log("The chicken is molting, it cannot lay an egg");
        } else {
            this.numberOfEggs++;
            console.log("The chicken has laid an egg")
        }
    }

    produce(productId) {

        this.product.id = productId;
        this.product.description = "Eggs";
        this.product.unit = "";
        this.product.quantity = this.numberOfEggs;

        console.log(`The chicken produced ${this.numberOfEggs} Eggs`);

        return this.product;
    }




    measureQuantity(unit, quantity) {

        if (this.isMolting) {
            console.log("The chicken is molting, it cannot produce eggs");

        } else {

            this.product.unit = unit;
            this.product.quantity = quantity;
            this.numberOfEggs += quantity;

            console.log(`Measure: ${quantity} ${unit} of eggs.`);
        }
    }
}