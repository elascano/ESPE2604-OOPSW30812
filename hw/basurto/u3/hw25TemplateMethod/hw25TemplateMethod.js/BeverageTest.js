import BeverageView from './view/BeverageView.js';
import BeverageController from './controller/BeverageController.js';
//@author Esteban Basurto, CodeBreakers,@ESPE
const view = new BeverageView();
const controller = new BeverageController(view);

async function run() {
    await controller.prepareTea();
    await controller.prepareCoffee();
    view.close();
}

run();