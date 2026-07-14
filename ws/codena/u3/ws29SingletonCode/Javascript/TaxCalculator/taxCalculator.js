import Tax from "./Tax.js";

const iva = Tax.getInstance();

const anotherTax = Tax.getInstance();

const percentage = 0.15;
const price = 1000;

iva.updateTaxPercentage(percentage);

const calculatedPrice = iva.salesTotal(price);

console.log("The percentage is:", iva.getPercentage());
console.log("The price is:", calculatedPrice + "$");

