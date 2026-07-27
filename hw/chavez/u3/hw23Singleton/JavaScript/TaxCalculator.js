const Tax = require("./tax");

class TaxCalculator {

    static main() {

        const tax = Tax.getInstance();
        //console.log(Tax)
        tax.updatetaxPercentage(15.0);

        let subtotal = 250.0;

        console.log("Tax Percentage: " + tax.getPercentage() + "%");
        console.log("Subtotal: $" + subtotal);
        console.log("Total with Tax: $" + tax.salesTotal(subtotal));
    }
}

TaxCalculator.main();