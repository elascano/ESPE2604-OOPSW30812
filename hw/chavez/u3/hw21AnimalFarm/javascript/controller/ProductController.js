const MongoManager = require("../utils/MongoManager");

class ProductController {

    constructor() {
        this.mongo = new MongoManager();
    }

    async saveProduct(product) {
        const database = await this.mongo.connect();
        const collection = database.collection("products");

        await collection.insertOne(product);

        console.log("Product saved successfully.");
    }

    async getProducts() {
        const database = await this.mongo.connect();
        const collection = database.collection("products");

        return await collection.find({}).toArray();
    }

    async findProduct(id) {
        const database = await this.mongo.connect();
        const collection = database.collection("products");

        return await collection.findOne({ id: id });
    }

    async updateProduct(id, product) {
        const database = await this.mongo.connect();
        const collection = database.collection("products");

        await collection.updateOne(
            { id: id },
            { $set: product }
        );

        console.log("Product updated successfully.");
    }

    async deleteProduct(id) {
        const database = await this.mongo.connect();
        const collection = database.collection("products");

        await collection.deleteOne({ id: id });

        console.log("Product deleted successfully.");
    }

}

module.exports = ProductController;