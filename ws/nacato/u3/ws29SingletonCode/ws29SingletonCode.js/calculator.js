const USTax = require('./model/USTax');
const CalculatorView = require('./view/CalculatorView');
const CalculatorController = require('./controller/CalculatorController');

// Angie Ñacato, Error 404, @ESPE

async function main() {
    const tax = USTax.getInstance();
    tax.salesTotal();

    const view = new CalculatorView();
    const controller = new CalculatorController(view);

    await controller.runInteractiveCalculation();
}

main();