//Jennyfer Nase
const Product = require('./product');
const Tax = require('./tax');


let id = 1;
let description = "computer";
let price = 100;

let pvp = Tax.computeTotal(price, 15);

let product = new Product(id, description, price);

console.log("product --> " + product.toString());


id = 2;
description = "mouse";
price = 1000;

pvp = Tax.computeTotal(price, 15);

let product2 = new Product(id, description, price, pvp);

console.log("product 2 --> " + product2.toString());