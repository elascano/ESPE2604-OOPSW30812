const USTax = require('./usTax');

class Calculator {
    static main() {
        const taxService = USTax.getInstance();

        const saleAmount = 100.0;
        const tax = taxService.calculateTax(saleAmount);
        const total = saleAmount + tax;

        console.log(`Sale Amount: $${saleAmount}`);
        console.log(`Applied Tax Rate: ${taxService.getTaxRate() * 100}%`);
        console.log(`Calculated Tax: $${tax}`);
        console.log(`Total Sale: $${total}`);
    }
}

Calculator.main();