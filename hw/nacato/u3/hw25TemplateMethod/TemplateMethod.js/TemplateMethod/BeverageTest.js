const Tea = require("./Tea");
const Coffee = require("./Coffee");

const tea = new Tea();
const coffee = new Coffee();

console.log("\n---Making tea...---");
tea.prepareRecipe();

console.log("\n---Making coffee...---");
coffee.prepareRecipe();