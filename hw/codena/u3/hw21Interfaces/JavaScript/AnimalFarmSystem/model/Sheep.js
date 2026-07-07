class Sheep extends FarmAnimal {
    constructor(id, breed, bornOnDate, weight, slaughterHouse, product, cuts, lastShearing, quantityOfWool) {
        super(id, breed, bornOnDate, weight, slaughterHouse, product, cuts)
        this.lastShearing = lastShearing;
        this.quantityOfWool = quantityOfWool;
    }

    feed(food) {
        console.log(`Feeding the sheep with --> ${food} and water`)
    }

    shear(){
        woolProduced = this.weight/150;
        return woolProduced;
    }

    produce(productId) {

        this.product.id = productId;
        this.product.description = "Wool";
        this.product.unit = "Kg";
        this.product.quantity = this.shear();

        console.log(`The sheep produced ${this.product.quantity} kg of wool`);

        return this.product;
    }

    measureQuantity(unit, quantity) {

            this.product.unit = unit;
            this.product.quantity = quantity;
            this.quantityOfWool += quantity;

            console.log(`Measure: ${quantity} ${unit} of wool.`);
        
    }
}