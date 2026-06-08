const express = require('express');
const router = express.Router();
const Product = require('../models/Product');

router.get('/alerts', async (req, res) => {
    try {
        const products = await Product.getAll();
        const alerts = [];
        const today = new Date();
        today.setHours(0, 0, 0, 0);

        for (const product of products) {
            if (product.expiryDate) {
                const expiryDate = new Date(product.expiryDate);
                const diffTime = expiryDate - today;
                const daysUntil = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
                
                if (daysUntil >= 0 && daysUntil <= 30) {
                    alerts.push({
                        productId: product.id,
                        productName: product.name,
                        expiryDate: product.expiryDate,
                        daysUntilExpiry: daysUntil
                    });
                    console.log(`ALERT: ${product.name} expires in ${daysUntil} days`);
                }
            }
        }
        
        res.json(alerts);
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

module.exports = router;