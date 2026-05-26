import { Tax } from "../../taxes-lib/tax.js";
import { Product } from "../model/product.js";

function main() {
    // Product 1
    let idVal = 1;
    let description = "computer";
    let price = 100.0;
    
    // Replicating Java line 29: pvp = price + Tax.computeTotal(price, 15F);
    let pvp = price + Tax.computeTotal(price, 15.0);
    
    // Constructor sets pvp via internal Tax.computeTotal(price, 15.0)
    let product = new Product(idVal, description, price);
    console.log("product -->" + product.toString());
    
    // Product 2
    idVal = 2;
    description = "mouse";
    price = 1000.0;
    
    // Replicating Java line 39: pvp = price + Tax.computeTotal(price, 15F);
    pvp = price + Tax.computeTotal(price, 15.0);
    
    // Constructor sets pvp to the passed pvp value
    let product2 = new Product(idVal, description, price, pvp);
    
    console.log("product 2 -->" + product2.toString());
}

main();
