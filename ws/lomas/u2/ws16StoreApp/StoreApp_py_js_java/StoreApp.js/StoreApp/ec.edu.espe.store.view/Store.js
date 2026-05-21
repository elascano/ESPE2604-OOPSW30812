import { Product } from '../ec.edu.espe.store.model/Product.js';
import { Tax } from '../utils/Tax.js';

function main() {
    let id;
    let description;
    let price;
    let pvp;
    let product;

  
    id = 1;
    description = "Computer";
    price = 100;

    pvp = Tax.computeTotal(price, 15);
    product = new Product(id, description, price);
    console.log("product---> " + product.toString());

   
    let product2;
    id = 2;
    description = "Mouse";
    price = 1000;

    pvp = Tax.computeTotal(price, 15);
    product2 = new Product(id, description, price);
    console.log("product---> " + product2.toString());
}

main();


