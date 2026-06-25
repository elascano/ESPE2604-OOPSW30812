import { MongoClient } from "mongodb";

const uri = "mongodb://Adrian:Adrian@ac-mcmbw4z-shard-00-00.e4n4vbs.mongodb.net:27017,ac-mcmbw4z-shard-00-01.e4n4vbs.mongodb.net:27017,ac-mcmbw4z-shard-00-02.e4n4vbs.mongodb.net:27017/hw17TypeScript?ssl=true&replicaSet=atlas-127ql3-shard-0&authSource=admin&retryWrites=true&w=majority";

const client = new MongoClient(uri);

let collection: any;

export class Database {
    async connect() {
        await client.connect();
        const db = client.db("hw17TypeScript");
        collection = db.collection("users");
    }

    getCollection() {
        return collection;
    }
}