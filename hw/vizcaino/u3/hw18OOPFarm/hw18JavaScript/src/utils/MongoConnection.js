import { MongoClient } from 'mongodb';
import dns from 'dns';
dns.setServers(['8.8.8.8', '8.8.4.4']);

export class MongoConnection {
    constructor() {
        this.connectionString = "mongodb+srv://Adrian:Adrian@cluster0.e4n4vbs.mongodb.net/farm?appName=Cluster0"; 
        this.dbName = "hw18JavaScript";
        this.client = null;
        this.db = null;
    }

    async connect() {
        if (!this.connectionString) {
            console.error(" ERROR: No has configurado tu 'connectionString' de MongoDB Atlas.");
            return false;
        }
        if (!this.db) {
            try {
                this.client = await MongoClient.connect(this.connectionString);
                this.db = this.client.db(this.dbName);
                console.log(`🔋 Conectado exitosamente a MongoDB Atlas: DB '${this.dbName}'`);
                return true;
            } catch (error) {
                console.error(" Error conectando a MongoDB Atlas:", error);
                throw error;
            }
        }
        return true;
    }

    getCollection(collectionName) {
        return this.db.collection(collectionName);
    }

    async create(collectionName, data) {
        await this.connect();
        return await this.getCollection(collectionName).insertOne(data);
    }

    async readAll(collectionName) {
        await this.connect();
        return await this.getCollection(collectionName).find({}).toArray();
    }

    async readById(collectionName, id) {
        await this.connect();
        return await this.getCollection(collectionName).findOne({ id: parseInt(id) });
    }

    async update(collectionName, id, updateData) {
        await this.connect();
        return await this.getCollection(collectionName).updateOne(
            { id: parseInt(id) },
            { $set: updateData }
        );
    }

    async delete(collectionName, id) {
        await this.connect();
        return await this.getCollection(collectionName).deleteOne({ id: parseInt(id) });
    }
}