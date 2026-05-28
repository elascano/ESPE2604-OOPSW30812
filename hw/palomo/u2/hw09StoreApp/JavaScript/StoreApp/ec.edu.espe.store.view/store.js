/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
import { Tax } from '../../../taxes-lib/texlib.js';
import { Product } from "../model/product.js";

function main() {
    let idVal = 1;
    let description = "computer";
    let price = 100.0;

    let pvp = Tax.computeTotal(price, 15.0);

    let product = new Product(idVal, description, price, pvp);
    console.log("product --> " + product.toString());

    idVal = 2;
    description = "mouse";
    price = 1000.0;

    pvp = Tax.computeTotal(price, 15.0);

    let product2 = new Product(idVal, description, price, pvp);
    console.log("product 2 --> " + product2.toString());
}

main();



