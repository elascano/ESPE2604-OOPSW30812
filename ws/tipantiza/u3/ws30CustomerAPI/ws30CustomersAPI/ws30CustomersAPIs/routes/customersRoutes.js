
const express = require("express");
const customer = require("../models/customers");
const router = express.Router();

router.get("/customers", async (req, res) => {
    try {
        const customers = await customer.find();
        res.json(customers);
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

router.get('/customer/:id', async (req, res) => {
    try {
        const customerObject = await customer.findOne({ id: req.params.id });
        if (customerObject === null) {
            res.status(404).json({ status: 404, message: "Customer not found" });
        } else {
            res.json(customerObject);
        }
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
});

router.post('/customer', async (req, res) => {
    try {
        const customerObject = new customer({
            id: req.body.id,
            name: req.body.name,
            age: req.body.age,
            moneySpent: req.body.moneySpent
        });
        const customerToSave = await customerObject.save();
        res.status(201).json(customerToSave);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
});

module.exports = router;