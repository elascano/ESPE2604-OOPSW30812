const express = require('express');

const fs = require('fs');

const router = express.Router();

const filePath = './data/products.json';

function getProducts() {

    return JSON.parse(
        fs.readFileSync(filePath)
    );
}

function saveProducts(products) {

    fs.writeFileSync(
        filePath,
        JSON.stringify(products, null, 2)
    );
}

router.get('/', (req, res) => {

    res.json(getProducts());
});

router.post('/', (req, res) => {

    const products = getProducts();

    const newProduct = {

        id: products.length + 1,

        ...req.body
    };

    products.push(newProduct);

    saveProducts(products);

    res.json(newProduct);
});

module.exports = router;
