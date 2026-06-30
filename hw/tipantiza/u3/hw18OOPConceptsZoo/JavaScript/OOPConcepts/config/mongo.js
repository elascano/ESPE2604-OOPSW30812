const { MongoClient } = require("mongodb");

const URI = "mongodb+srv://tipantizaalexander:Alexander20@cluster0.z86uqo3.mongodb.net/?appName=Cluster0";
const DATABASE = "FarmAnimalJs";

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