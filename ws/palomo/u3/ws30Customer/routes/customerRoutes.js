const express = require("express");
const customer = require("../models/customer");
const router = express.Router();

router.get("/customers", async (req, res) => {
  try {
    const customers = await customer.find();
    res.json(customers);
    } catch (err) {
    res.status(500).json({ message: err.message });
    }
    });

    router.get("/customers/:id", async (req, res) => {
    try {
        const customers = await customer.findOne({ id: req.params.id });
        if (customers == null) {
            res.status(404).json({ status: 404});
        } else {
            res.json(customersObject);
        }
    } 
    catch (err) {
        res.status(500).json({ message: err.message });
    }
});

router.post('/customers', async (req, res) => {
    const customersObject = new customer({
        id: req.body.id,
        name: req.body.name,
        age: req.body.age,
        moneySpent: req.body.moneySpent,
    })
    try {
        const customersObjectToSave = await customersObject.save();
        res.status(200).json(customersToSave);
    }
    catch (error) {
        res.status(500).json({ message: error.message });
    }
});

module.exports = router;
