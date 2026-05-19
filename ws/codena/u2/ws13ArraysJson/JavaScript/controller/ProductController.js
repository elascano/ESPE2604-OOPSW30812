const fs = require("fs");
const Product = require("../model/Product");

class ProductController {

    constructor(view) {
        this.view = view;
        this.products = [];
        this.filePath = "./data/products.json";
    }

    addProduct(name, weightPounds) {

        const product = new Product(name, weightPounds);

        this.products.push(product);
    }

    saveProductsToJSON() {

        fs.writeFileSync(
            this.filePath,
            JSON.stringify(this.products, null, 2)
        );

        this.view.showMessage("\nProducts saved successfully.");
    }

    readProductsAndConvert() {

        if (!fs.existsSync(this.filePath)) {

            this.view.showMessage("\nJSON file not found.");

            return;
        }

        const data = fs.readFileSync(this.filePath);

        const products = JSON.parse(data);

        const convertedProducts = products.map(product => {

            const kilograms = product.weightPounds * 0.453592;

            return {
                name: product.name,
                weightKilograms: kilograms
            };
        });

        this.view.showProducts(convertedProducts);
    }
}

module.exports = ProductController;