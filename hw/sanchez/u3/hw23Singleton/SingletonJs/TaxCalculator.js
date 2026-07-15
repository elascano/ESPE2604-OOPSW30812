const Tax = require("./Tax");

function main() {
    const tax = Tax.getInstance();
    tax.updateTaxPercentage(15.0);

    const sale = 100.0;

    console.log(`Sale: $${sale}`);
    console.log(`Tax Percentage: ${tax.getPercentage()}%`);
    console.log(`Total: $${tax.salesTotal(sale)}`);
}

main();