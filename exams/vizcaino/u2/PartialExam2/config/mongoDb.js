const { MongoClient } = require("mongodb");

const uri =
"mongodb+srv://Adrian:Adrian@cluster0.e4n4vbs.mongodb.net/?appName=Cluster0";

const client = new MongoClient(uri);

let database = null;

async function getDatabase() {

    if (database) {
        return database;
    }

    await client.connect();

    console.log("MongoDB Connected");

    database = client.db("ExamPartial2");

    return database;
}

module.exports = { getDatabase };