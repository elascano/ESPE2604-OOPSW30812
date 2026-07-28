const { MongoClient } = require("mongodb");

class MongoConnection {

    constructor() {

        if (MongoConnection.instance) {
            return MongoConnection.instance;
        }

        this.uri = "mongodb+srv://odalys:odalys@cluster0.2cf9puv.mongodb.net/?appName=Cluster0";
        this.client = new MongoClient(this.uri);
        this.database = null;

        MongoConnection.instance = this;
    }


    async connect() {

        if (!this.database) {

            await this.client.connect();

            this.database = this.client.db("StrategyDB");

            console.log("Connected to MongoDB Atlas");

        }

        return this.database;
    }

}

module.exports = new MongoConnection();