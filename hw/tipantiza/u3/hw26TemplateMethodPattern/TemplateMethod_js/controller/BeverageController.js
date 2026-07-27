const Tea = require('../model/Tea');
const Coffee = require('../model/Coffee');
const Chocolate = require('../model/Chocolate');

class BeverageController {
    async prepareAllBeverages() {
        const tea = new Tea();
        const coffee = new Coffee();
        const chocolate = new Chocolate();

        console.log("\nMaking tea ...");
        await tea.prepareRecipe();

        console.log("\nMaking coffee ...");
        await coffee.prepareRecipe();

        console.log("\nMaking chocolate ...");
        await chocolate.prepareRecipe();
    }
}

module.exports = BeverageController;