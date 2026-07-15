const Tax = require("./tax");
const tax = Tax.getInstance();
tax.updateTaxPercentage(0.15);
console.log(`Tax: ${(tax.percentage * 100).toFixed(2)}%`);
console.log(`Total: $${tax.salesTotal(100).toFixed(2)}`);
