const Product = require('./model/product');
const Tax = require('./utils/tax');

let id = 1;
let description = "computer";
let price = 100;

let pvp = Tax.computeTotal(price, 15);

let product = new Product(id, description, price);

console.log("Product ---> " + product.toString());

id = 2;
description = "Mouse";
price = 1000;

pvp = Tax.computeTotal(price, 15);

let product2 = new Product(id, description, price, pvp);

console.log("Product2 ---> " + product2.toString());