const { Tax } = require('../model/tax.js');

function main() {
    const tax = Tax.getInstance();
    tax.updateTaxPercentage(15);
    const subtotal = 100;
    console.log(`Tax percentage: ${tax.getPercentage()}%`);
    console.log(`Subtotal: $${subtotal}`);
    console.log(`Total: $${tax.salesTotal(subtotal)}`);
}

module.exports = { main };