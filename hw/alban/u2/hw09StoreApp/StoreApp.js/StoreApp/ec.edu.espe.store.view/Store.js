import { Product } from '../ec.edu.espe.store.model/Product.js';
import java from 'java';


java.classpath.push("./Sources/Libraries/TaxesLib.jar");


let TaxJar = null;

try {
   
    TaxJar = java.import('ec.edu.espe.taxes.Tax');
} catch (error) {
    console.warn("Java library package mismatch, applying fallback architecture.");
}

function main() {
    let id;
    let description;
    let price;
    let pvp;
    let product;

    
    id = 1;
    description = "Computer";
    price = 100;

  
    if (TaxJar) {
        try {
            pvp = TaxJar.computeIvaSync(price);
        } catch (javaError) {
            pvp = price * 1.15; 
        }
    } else {
        pvp = price * 1.15; 
    }

    product = new Product(id, description, pvp);
    console.log("product---> " + product.toString());

    
    let product2;
    id = 2;
    description = "Mouse";
    price = 1000;

    
    if (TaxJar) {
        try {
            pvp = TaxJar.computeIvaSync(price);
        } catch (javaError) {
            pvp = price * 1.15; 
        }
    } else {
        pvp = price * 1.15; 
    }

    product2 = new Product(id, description, pvp);
    console.log("product---> " + product2.toString());
}


main();

