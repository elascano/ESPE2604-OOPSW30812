const BeverageController = require('../controller/BeverageController');

async function main() {
    const controller = new BeverageController();
    await controller.prepareAllBeverages();
}

main();