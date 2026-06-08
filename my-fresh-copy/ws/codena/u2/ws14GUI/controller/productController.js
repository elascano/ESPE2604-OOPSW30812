const fs = require('fs');
const path = require('path');
const Product = require('../model/productModel');

const filePath = path.join(__dirname, '../data/products.json');

function saveProduct(name, id, price, weightLb) {

    const product = new Product(name, id, price, weightLb);

    let products = [];

    if (fs.existsSync(filePath)) {
        const data = fs.readFileSync(filePath);

        if (data.length > 0) {
            products = JSON.parse(data);
        }
    }

    products.push(product);

    fs.writeFileSync(filePath, JSON.stringify(products, null, 2));

    return "Product saved successfully!";
}

function getProducts() {

    if (!fs.existsSync(filePath)) {
        return [];
    }

    const data = fs.readFileSync(filePath);

    if (data.length === 0) {
        return [];
    }

    const products = JSON.parse(data);

    return products.map(p => ({
        ...p,
        weightKg: (p.weightLb * 0.453592).toFixed(2)
    }));
}

module.exports = {
    saveProduct,
    getProducts
};