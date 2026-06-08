const express = require('express');
const router = express.Router();
const Credit = require('../models/Credit');

router.get('/', async (req, res) => {
    try {
        const credits = await Credit.getAll();
        res.json(credits);
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

router.get('/:id', async (req, res) => {
    try {
        const credit = await Credit.getById(parseInt(req.params.id));
        if (credit) {
            res.json(credit);
        } else {
            res.status(404).json({ error: 'Credit account not found' });
        }
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

router.post('/', async (req, res) => {
    try {
        const credit = await Credit.create(req.body);
        res.json({ message: 'Credit account added successfully', credit });
    } catch (error) {
        res.status(400).json({ error: error.message });
    }
});

router.put('/:id', async (req, res) => {
    try {
        const updated = await Credit.update(parseInt(req.params.id), req.body);
        if (updated) {
            res.json({ message: 'Credit account updated successfully' });
        } else {
            res.status(404).json({ error: 'Credit account not found' });
        }
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

router.delete('/:id', async (req, res) => {
    try {
        const deleted = await Credit.remove(parseInt(req.params.id));
        if (deleted) {
            res.json({ message: 'Credit account deleted successfully' });
        } else {
            res.status(404).json({ error: 'Credit account not found' });
        }
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

module.exports = router;