const { MongoClient } = require("mongodb");

const URI = "mongodb+srv://daniel:password@cluster0.zfwd5wx.mongodb.net/?appName=Cluster0";
const DATABASE = "FarmJs";

let database = null;
let client = null;

async function connect() {

    try {

        if (database == null) {

            client = new MongoClient(URI);

            await client.connect();

            database = client.db(DATABASE);

            console.log("Connected to MongoDB");

        }

        return database;

    } catch (error) {

        console.error("MongoDB Connection Error:");

        console.error(error);

    }

}

module.exports = {
    connect
};