const Tea = require("./model/Tea");
const Coffee = require("./model/Coffee");

const tea = new Tea();
const coffee = new Coffee();

console.log("\nMaking tea...");
tea.prepareRecipe();

console.log("\nMaking coffee...");
coffee.prepareRecipe();