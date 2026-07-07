const { MongoClient } = require("mongodb");

class MongoManager {

    constructor() {
        this.uri = "mongodb+srv://odalys:odalys@cluster0.2cf9puv.mongodb.net/AnimalFarmDB?retryWrites=true&w=majority&appName=Cluster0";
        this.client = new MongoClient(this.uri);
        this.database = null;
    }

    async connect() {
        await this.client.connect();
        this.database = this.client.db("AnimalFarmDB");
        console.log("Connected to MongoDB Atlas");
        return this.database;
    }

    async close() {
        await this.client.close();
        console.log("Connection closed");
    }

}

module.exports = MongoManager;