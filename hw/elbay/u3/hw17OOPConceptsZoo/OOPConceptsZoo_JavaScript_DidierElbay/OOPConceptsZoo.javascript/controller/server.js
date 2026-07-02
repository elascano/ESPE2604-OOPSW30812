/**
 * server.js - Express backend for Farm Management System
 * @author Didier Elbay
 *
 * Setup:
 *   npm install express mongodb cors
 *   node server.js
 */

const express = require('express');
const { MongoClient } = require('mongodb');
const cors = require('cors');

const app = express();
app.use(express.json());
app.use(cors());

// Replace with your own MongoDB Atlas connection string
const uri = "mongodb+srv://YOUR_USER:YOUR_PASSWORD@YOUR_CLUSTER.mongodb.net/?appName=FarmZoo";
const client = new MongoClient(uri);
let db;

async function connectDB() {
    try {
        await client.connect();
        db = client.db("FarmZooDB");
        console.log("Connected to MongoDB Atlas!");
    } catch (e) {
        console.error("Database connection error:", e);
        process.exit(1);
    }
}
connectDB();

// --- Auth ---
app.post('/api/login', async (req, res) => {
    const { username, password } = req.body;
    if (!username || !password) {
        return res.status(400).json({ success: false, message: "Username and password are required." });
    }
    try {
        const user = await db.collection("Users").findOne({ username, password });
        if (user) {
            res.json({ success: true });
        } else {
            res.status(401).json({ success: false, message: "Invalid username or password" });
        }
    } catch (e) {
        res.status(500).json({ success: false, message: e.message });
    }
});

// --- Animal CRUD ---
const ALLOWED_COLLECTIONS = ['chickens', 'cows', 'pigs', 'sheeps'];

app.post('/api/animals/:collection', async (req, res) => {
    const { collection } = req.params;
    if (!ALLOWED_COLLECTIONS.includes(collection)) {
        return res.status(400).json({ success: false, message: "Invalid collection name." });
    }
    try {
        const result = await db.collection(collection).insertOne({
            ...req.body,
            date: new Date()
        });
        res.json({ success: true, result });
    } catch (e) {
        res.status(500).json({ success: false, message: e.message });
    }
});

app.delete('/api/animals/:collection/:id', async (req, res) => {
    const { collection } = req.params;
    if (!ALLOWED_COLLECTIONS.includes(collection)) {
        return res.status(400).json({ success: false, message: "Invalid collection name." });
    }
    try {
        const id = parseInt(req.params.id, 10);
        if (isNaN(id)) {
            return res.status(400).json({ success: false, message: "ID must be a number." });
        }
        const result = await db.collection(collection).findOneAndDelete({ id });
        if (result) {
            res.json({ success: true, message: "Record deleted successfully" });
        } else {
            res.status(404).json({ success: false, message: "ID not found" });
        }
    } catch (e) {
        res.status(500).json({ success: false, message: e.message });
    }
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => console.log(`Server running on http://localhost:${PORT}`));
