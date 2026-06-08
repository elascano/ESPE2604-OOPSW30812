const Product = require('../model/Product');
let product = new Product(1, "computer", 100);

console.log(product.toString());

let product2 = new Product(2, "mouse", 1000);

console.log(product2.toString());