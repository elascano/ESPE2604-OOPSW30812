import FarmAnimal from "./FarmAnimal.js";
import Product from "./Product.js";

export default class Sheep extends FarmAnimal {

    produce() {
        const product = new Product("Wool");
        console.log(`Sheep produced ${product}`);
    }
}