import FarmAnimal from "./FarmAnimal.js";
import Product from "./Product.js";

export default class Chicken extends FarmAnimal {

    produce() {
        const product = new Product("Eggs");
        console.log(`Chicken produced ${product}`);
    }
}