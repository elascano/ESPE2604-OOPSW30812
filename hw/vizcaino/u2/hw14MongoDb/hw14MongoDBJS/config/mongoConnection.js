const dns = require("dns");

dns.setServers(["8.8.8.8", "8.8.4.4"]);

const { MongoClient } = require("mongodb");

const uri =
"mongodb+srv://Adrian:Adrian@cluster0.e4n4vbs.mongodb.net/?appName=Cluster0";

const client = new MongoClient(uri);

async function getDatabase() {

    await client.connect();

    return client.db("hw14MongoDBJS");
}

module.exports = { getDatabase };