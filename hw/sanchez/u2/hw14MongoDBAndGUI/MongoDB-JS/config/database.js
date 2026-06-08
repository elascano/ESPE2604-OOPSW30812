const { MongoClient } = require('mongodb');
require('dotenv').config();

const uri = process.env.MONGO_URI;
const dbName = process.env.DATABASE_NAME;

let client = null;
let db = null;

async function connect() {
    try {
        client = new MongoClient(uri);
        await client.connect();
        db = client.db(dbName);
        console.log('Connected to MongoDB Atlas');
        return db;
    } catch (error) {
        console.error('MongoDB connection error:', error);
        throw error;
    }
}

function getDatabase() {
    return db;
}

async function close() {
    if (client) {
        await client.close();
        console.log('Disconnected from MongoDB');
    }
}

module.exports = { connect, getDatabase, close };