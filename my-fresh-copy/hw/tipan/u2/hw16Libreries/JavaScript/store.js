const Product = require("./model/product");

let id = 1;
let description = "computer";
let price = 100;

let product = new Product(id, description, price);

console.log(product.toString());
console.log("PVP = " + product.pvp);