const Tea = require('./tea');
const Coffee = require('./coffee');

class BeverageTest {
    static async main() {
        const tea = new Tea();
        const coffee = new Coffee();

        console.log("\nMaking tea ...");
        await tea.prepareRecipe();

        console.log("\nMaking coffee ...");
        await coffee.prepareRecipe();
    }
}

BeverageTest.main();