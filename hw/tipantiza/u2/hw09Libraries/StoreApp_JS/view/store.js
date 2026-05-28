const Product = require('../model/product');
const Tax = require('taxeslib');

class Store {
    static executeSimulation() {
        console.log("=========================================");
        console.log("   STORE APPLICATION - CLEAN CODE JS     ");
        console.log("=========================================\n");

        const activeTaxPercentage = 15;

        const firstId = 1;
        const firstDescription = "Computer";
        const firstBasePrice = 100.00;
        
        const firstPublicSalePrice = Tax.computeTotalWithTax(firstBasePrice, activeTaxPercentage);
        const firstProduct = new Product(firstId, firstDescription, firstBasePrice, firstPublicSalePrice);
        
        console.log(`Process result ---> ${firstProduct.toString()}\n`);

        const secondId = 2;
        const secondDescription = "Mouse";
        const secondBasePrice = 1000.00;
        
        const secondPublicSalePrice = Tax.computeTotalWithTax(secondBasePrice, activeTaxPercentage);
        const secondProduct = new Product(secondId, secondDescription, secondBasePrice, secondPublicSalePrice);
        
        console.log(`Process result ---> ${secondProduct.toString()}\n`);
    }
}

Store.executeSimulation();