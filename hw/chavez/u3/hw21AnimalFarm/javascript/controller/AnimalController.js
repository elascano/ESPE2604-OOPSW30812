const MongoManager = require("../utils/MongoManager");

class AnimalController {

    constructor() {
        this.mongo = new MongoManager();
    }

    async saveAnimal(animal) {
        const database = await this.mongo.connect();
        const collection = database.collection("animals");

        await collection.insertOne(animal);

        console.log("Animal saved successfully.");
    }

    async getAnimals() {
        const database = await this.mongo.connect();
        const collection = database.collection("animals");

        return await collection.find({}).toArray();
    }

    async findAnimal(id) {
        const database = await this.mongo.connect();
        const collection = database.collection("animals");

        return await collection.findOne({ id: id });
    }

    async updateAnimal(id, animal) {
        const database = await this.mongo.connect();
        const collection = database.collection("animals");

        await collection.updateOne(
            { id: id },
            { $set: animal }
        );

        console.log("Animal updated successfully.");
    }

    async deleteAnimal(id) {
        const database = await this.mongo.connect();
        const collection = database.collection("animals");

        await collection.deleteOne({ id: id });

        console.log("Animal deleted successfully.");
    }

}

module.exports = AnimalController;