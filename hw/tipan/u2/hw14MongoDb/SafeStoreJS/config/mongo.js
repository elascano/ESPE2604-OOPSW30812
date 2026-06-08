const { MongoClient } = require("mongodb");

const uri = "mongodb://Ronald:Ronald@ac-2ekftlx-shard-00-00.cd2ybxo.mongodb.net:27017,ac-2ekftlx-shard-00-01.cd2ybxo.mongodb.net:27017,ac-2ekftlx-shard-00-02.cd2ybxo.mongodb.net:27017/SafeStoreDB?ssl=true&replicaSet=atlas-mtapmh-shard-0&authSource=admin&retryWrites=true&w=majority";

const client = new MongoClient(uri);

async function connectDB() {
    await client.connect();
    return client.db("SafeStoreDB");
}

module.exports = connectDB;