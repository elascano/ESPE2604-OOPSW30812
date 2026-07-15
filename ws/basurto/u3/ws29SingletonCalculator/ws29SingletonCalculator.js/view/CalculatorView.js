const readline = require('readline/promises');
const { stdin: input, stdout: output } = require('process');

class CalculatorView {
    constructor() {
        this.rl = readline.createInterface({ input, output });
    }

    async getInputAmount() {
        const answer = await this.rl.question("Enter the subtotal amount: ");
        return parseFloat(answer);
    }

    async getInputTaxRate() {
        const answer = await this.rl.question("Enter the tax rate percentage: ");
        return parseFloat(answer);
    }

    displayResult(total) {
        console.log("=======================================");
        console.log(`Total sales with tax: $${total.toFixed(2)}`);
        console.log("=======================================");
    }

    closeScanner() {
        this.rl.close();
    }
}

module.exports = CalculatorView;