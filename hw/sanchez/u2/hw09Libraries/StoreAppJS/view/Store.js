
//author Joel Sanchez <The_Softwarriors at ESPE>

const Product = require('../model/Product');
const Tax = require('taxeslib');

class Store {
    static main() {

        console.log("         STORE APP - WITH TAXESLIB");

        
        // Product 1
        let id = 1;
        let description = "computer";
        let price = 100.0;
        
        let product = new Product(id, description, price);
        console.log("product --->" + product.toString());
        
        // Product 2
        id = 2;
        description = "mouse";
        price = 1000.0;
        
        let product2 = new Product(id, description, price);
        console.log("product 2 ---> " + product2.toString());
        
        // Product 3 (with custom PVP)
        id = 3;
        description = "keyboard";
        price = 50.0;
        let customPvp = 75.0;
        
        let product3 = new Product(id, description, price, customPvp);
        console.log("\nproduct 3 ---> " + product3.toString());
        
    }
}

if (require.main === module) {
    Store.main();
}

module.exports = Store;