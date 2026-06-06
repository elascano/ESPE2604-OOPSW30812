const { MongoClient } = require('mongodb');

class BillingController {
    constructor() {
        this.uri = "mongodb+srv://admin:Espe2026@christopher.i75hlaj.mongodb.net/?retryWrites=true&w=majority";
        this.client = new MongoClient(this.uri);
        this.db = null;
    }

    async connectToDatabase() {
        try {
            await this.client.connect();
            await this.client.db("admin").command({ ping: 1 });
            console.log("Success: Connected to MongoDB Atlas from Node.js GUI!");
            this.db = this.client.db('BillingDB');
            return true;
        } catch (error) {
            console.error("Error: Database connection failed.", error);
            return false;
        }
    }

    // --- PERSON METHODS ---
    async saveOrUpdatePerson(personObj) {
        if (!this.db) throw new Error("No database connection.");
        const collection = this.db.collection('persons');
        await collection.updateOne({ _id: personObj.personId }, { $set: personObj.toDict() }, { upsert: true });
    }

    async findPerson(personId) {
        if (!this.db) throw new Error("No database connection.");
        return await this.db.collection('persons').findOne({ _id: personId });
    }

    // --- PRODUCT METHODS ---
    async saveOrUpdateProduct(productObj) {
        if (!this.db) throw new Error("No database connection.");
        await this.db.collection('products').updateOne({ _id: productObj.productId }, { $set: productObj.toDict() }, { upsert: true });
    }

    async findProduct(productId) {
        if (!this.db) throw new Error("No database connection.");
        return await this.db.collection('products').findOne({ _id: productId });
    }

    // --- PAYMENT METHODS ---
    async saveOrUpdatePayment(paymentObj) {
        if (!this.db) throw new Error("No database connection.");
        await this.db.collection('payments').updateOne({ _id: paymentObj.paymentId }, { $set: paymentObj.toDict() }, { upsert: true });
    }

    async findPayment(paymentId) {
        if (!this.db) throw new Error("No database connection.");
        return await this.db.collection('payments').findOne({ _id: paymentId });
    }
}

// Ensure the class is exported correctly
module.exports = BillingController;