const { MongoClient } = require("mongodb");

const uri = "mongodb+srv://Ronald:Ronald@cluster0.cd2ybxo.mongodb.net/?appName=Cluster0";

const client = new MongoClient(uri);

async function getDatabase() {
    await client.connect();
    return client.db("FarmDB");
}

module.exports = getDatabase;