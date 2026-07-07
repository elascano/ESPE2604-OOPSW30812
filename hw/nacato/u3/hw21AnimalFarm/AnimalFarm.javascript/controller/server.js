//npm install express mongodb cors
//node server.js
const express = require('express');
const { MongoClient } = require('mongodb');
const cors = require('cors');

const app = express();
app.use(express.json());
app.use(cors());

const uri = "mongodb+srv://Angie:Angie@angienx.spphrbg.mongodb.net/";
const client = new MongoClient(uri);
let db;

async function connectDB() {
    try {
        await client.connect();
        db = client.db("FarmZooDB");
        console.log("Connected to MongoDB Atlas!");
    } catch (e) {
        console.error("Database connection error:", e);
    }
}
connectDB();

app.post('/api/login', async (req, res) => {
    const { username, password } = req.body;
    try {
        const user = await db.collection("Users").findOne({ username, password });
        if (user) {
            res.json({ success: true });
        } else {
            res.json({ success: false, message: "Invalid username or password" });
        }
    } catch (e) {
        res.status(500).json({ success: false, message: e.message });
    }
});

app.post('/api/animals/:collection', async (req, res) => {
    try {
        const result = await db.collection(req.params.collection).insertOne({
            ...req.body,
            date: new Date()
        });
        res.json({ success: true, result });
    } catch (e) {
        res.status(500).json({ success: false, message: e.message });
    }
});

app.delete('/api/animals/:collection/:id', async (req, res) => {
    try {
        const id = parseInt(req.params.id);
        const result = await db.collection(req.params.collection).findOneAndDelete({ id: id });
        if (result) {
            res.json({ success: true, message: "Record deleted successfully" });
        } else {
            res.json({ success: false, message: "ID not found in Atlas" });
        }
    } catch (e) {
        res.status(500).json({ success: false, message: e.message });
    }
});

app.listen(3000, () => console.log("Server running on http://localhost:3000"));