"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Database = void 0;
const mongodb_1 = require("mongodb");
const uri = "mongodb://Adrian:Adrian@ac-mcmbw4z-shard-00-00.e4n4vbs.mongodb.net:27017,ac-mcmbw4z-shard-00-01.e4n4vbs.mongodb.net:27017,ac-mcmbw4z-shard-00-02.e4n4vbs.mongodb.net:27017/hw17TypeScript?ssl=true&replicaSet=atlas-127ql3-shard-0&authSource=admin&retryWrites=true&w=majority";
const client = new mongodb_1.MongoClient(uri);
let collection;
class Database {
    async connect() {
        await client.connect();
        const db = client.db("hw17TypeScript");
        collection = db.collection("users");
    }
    getCollection() {
        return collection;
    }
}
exports.Database = Database;
