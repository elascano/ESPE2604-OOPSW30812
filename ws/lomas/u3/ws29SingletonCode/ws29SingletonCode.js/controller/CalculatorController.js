const USTax = require('../model/USTax');

class CalculatorController {
    constructor(view) {
        this.view = view;
    }

    runDefaultCalculation() {
        const tax = USTax.getInstance();
        const total = tax.salesTotal();
        this.view.displayResult(total);
    }

    async runInteractiveCalculation() {
        const amount = await this.view.getInputAmount();
        const taxRate = await this.view.getInputTaxRate();
        
        const tax = USTax.getInstance();
        const total = tax.calculateTax(amount, taxRate);
        
        this.view.displayResult(total);
        this.view.closeScanner();
    }
}

module.exports = CalculatorController;