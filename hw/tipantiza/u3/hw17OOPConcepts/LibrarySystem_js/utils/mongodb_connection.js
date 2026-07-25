const { MongoClient } = require('mongodb');

class MongoDBConnection {
    static _instance = null;
    static BOOKS_COLLECTION = "books";
    static USERS_COLLECTION = "users";
    static LOANS_COLLECTION = "loans";
    
    static CONNECTION_STRING = "mongodb+srv://tipantizaalexander:Alexander20@cluster0.z86uqo3.mongodb.net/?appName=Cluster0";
    static DATABASE_NAME = "library_js_db";
    
    constructor() {
        if (MongoDBConnection._instance) {
            return MongoDBConnection._instance;
        }
        
        this._client = null;
        this._database = null;
        this._connected = false;
        this._initialize();
        MongoDBConnection._instance = this;
    }
    
    static getInstance() {
        if (!MongoDBConnection._instance) {
            MongoDBConnection._instance = new MongoDBConnection();
        }
        return MongoDBConnection._instance;
    }
    
    async _initialize() {
        try {
            this._client = new MongoClient(MongoDBConnection.CONNECTION_STRING);
            await this._client.connect();
            this._database = this._client.db(MongoDBConnection.DATABASE_NAME);
            await this._database.listCollections().next();
            this._connected = true;
            console.log(`Connected successfully to MongoDB: ${MongoDBConnection.DATABASE_NAME}`);
        } catch (error) {
            console.log(`Warning: MongoDB not available - ${error.message}`);
            console.log("Running in memory-only mode");
            this._connected = false;
            this._client = null;
            this._database = null;
        }
    }
    
    getCollection(collectionName) {
        if (!this._connected || !this._database) {
            return null;
        }
        return this._database.collection(collectionName);
    }
    
    _toDict(obj) {
        const result = {};
        for (const key in obj) {
            if (key.startsWith('_')) {
                const cleanKey = key.substring(1);
                const value = obj[key];
                if (value instanceof Date) {
                    result[cleanKey] = value.toISOString();
                } else {
                    result[cleanKey] = value;
                }
            }
        }
        return result;
    }
    
    async insertDocument(collectionName, entity) {
        if (!this._connected) {
            return;
        }
        try {
            const collection = this.getCollection(collectionName);
            if (!collection) return;
            const document = this._toDict(entity);
            await collection.insertOne(document);
        } catch (error) {
            console.log(`Warning: Could not insert document - ${error.message}`);
        }
    }
    
    async findAllDocuments(collectionName, entityClass) {
        const results = [];
        if (!this._connected) {
            return results;
        }
        try {
            const collection = this.getCollection(collectionName);
            if (!collection) return results;
            const cursor = collection.find();
            const documents = await cursor.toArray();
            
            for (const document of documents) {
                const entity = new entityClass();
                for (const key in document) {
                    const privateKey = `_${key}`;
                    if (entity.hasOwnProperty(privateKey)) {
                        entity[privateKey] = document[key];
                    } else if (entity.hasOwnProperty(key)) {
                        entity[key] = document[key];
                    }
                }
                results.push(entity);
            }
        } catch (error) {
            console.log(`Warning: Could not retrieve documents - ${error.message}`);
        }
        return results;
    }
    
    async findDocumentById(collectionName, id, entityClass) {
        if (!this._connected) {
            return null;
        }
        try {
            const collection = this.getCollection(collectionName);
            if (!collection) return null;
            const document = await collection.findOne({ id: id });
            
            if (document) {
                const entity = new entityClass();
                for (const key in document) {
                    const privateKey = `_${key}`;
                    if (entity.hasOwnProperty(privateKey)) {
                        entity[privateKey] = document[key];
                    } else if (entity.hasOwnProperty(key)) {
                        entity[key] = document[key];
                    }
                }
                return entity;
            }
        } catch (error) {
            console.log(`Warning: Could not find document - ${error.message}`);
        }
        return null;
    }
    
    async updateDocument(collectionName, id, entity) {
        if (!this._connected) {
            return;
        }
        try {
            const collection = this.getCollection(collectionName);
            if (!collection) return;
            const document = this._toDict(entity);
            await collection.updateOne({ id: id }, { $set: document });
        } catch (error) {
            console.log(`Warning: Could not update document - ${error.message}`);
        }
    }
    
    async deleteDocument(collectionName, id) {
        if (!this._connected) {
            return;
        }
        try {
            const collection = this.getCollection(collectionName);
            if (!collection) return;
            await collection.deleteOne({ id: id });
        } catch (error) {
            console.log(`Warning: Could not delete document - ${error.message}`);
        }
    }
    
    async isConnected() {
        if (!this._connected || !this._database) {
            return false;
        }
        try {
            await this._database.listCollections().next();
            return true;
        } catch (error) {
            return false;
        }
    }
    
    async close() {
        if (this._client) {
            await this._client.close();
            this._connected = false;
            console.log("MongoDB connection closed");
        }
    }
}

module.exports = MongoDBConnection;