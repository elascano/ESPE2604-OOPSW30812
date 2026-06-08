const { MongoClient } = require('mongodb');

class MongoConnection {
    static _client = null;

    static getDatabase() {
        if (!this._client) {
            const uri = "mongodb+srv://Jennyfer:jennyfer@jennyfer.owlaicw.mongodb.net/?appName=Jennyfer";
            
            this._client = new MongoClient(uri);
        }
        return this._client.db("MothersAppDB");
    }
}

module.exports = MongoConnection;