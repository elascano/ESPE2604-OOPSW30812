import { Console } from './view/Console.js';
import { StockController } from './controller/StockController.js';

// Jennyfer Nase

function main() {
    const view = new Console();
    const controller = new StockController(view);
    
    controller.startSimulation();
}

main();