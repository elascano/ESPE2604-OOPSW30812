const MongoManager = require("../utils/MongoManager");

class SlaughterController {

    constructor() {
        this.mongo = new MongoManager();
    }

    async saveCut(cut) {
        const database = await this.mongo.connect();
        const collection = database.collection("cuts");

        await collection.insertOne(cut);

        console.log("Cut saved successfully.");
    }

    async getCuts() {
        const database = await this.mongo.connect();
        const collection = database.collection("cuts");

        return await collection.find({}).toArray();
    }

    async findCut(id) {
        const database = await this.mongo.connect();
        const collection = database.collection("cuts");

        return await collection.findOne({ id: id });
    }

    async updateCut(id, cut) {
        const database = await this.mongo.connect();
        const collection = database.collection("cuts");

        await collection.updateOne(
            { id: id },
            { $set: cut }
        );

        console.log("Cut updated successfully.");
    }

    async deleteCut(id) {
        const database = await this.mongo.connect();
        const collection = database.collection("cuts");

        await collection.deleteOne({ id: id });

        console.log("Cut deleted successfully.");
    }

}

module.exports = SlaughterController;