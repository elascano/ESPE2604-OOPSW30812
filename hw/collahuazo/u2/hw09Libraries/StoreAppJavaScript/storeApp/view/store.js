/**
 * @author: Collahuazo Brandon, CodeBros, @ESPE
 */

import { Product } from '../model/product.js';
import { Tax } from '../../TaxLib/utils/tax.js';

function main() {

    let id = 1;
    let descripcion = "compute";
    let price = 100.0;
    
    let pvp = Tax.computeTotal(price, 15);
    let product = new Product(id, descripcion, price);
    console.log(`product ---> ${product.toString()}`);
    

    id = 2;
    descripcion = "mouse";
    price = 1000.0;
    
    pvp = Tax.computeTotal(price, 15);
    let product2 = new Product(id, descripcion, price);
    console.log(`product 2 ---> ${product2.toString()}`);
}

main();