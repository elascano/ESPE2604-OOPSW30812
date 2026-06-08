const { MongoClient } = require("mongodb");

const client = new MongoClient(
    "URI"
);

async function getDb() {

    await client.connect();

    return client.db("SchoolSystem");
}

module.exports = {
    getDb
};