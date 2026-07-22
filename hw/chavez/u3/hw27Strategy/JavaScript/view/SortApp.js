const SortingContext = require("../controller/SortingContext");

const data = [3, 6, 4, 6, 7, 8, 5, 6, 7, 5, 3, 3];

const context = new SortingContext();

const resultado = context.sort(data);

console.log("Ordered arrangement:");
console.log(resultado);
