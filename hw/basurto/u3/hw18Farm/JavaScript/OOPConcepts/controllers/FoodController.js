const { connect } = require("../config/mongo");

const Food = require("../models/Food");

class FoodController {

    constructor() {

        this.collectionName = "foods";

    }

    async getCollection() {
        const database = await connect();
        return database.collection(this.collectionName);

    }

    async create(food) {
        const collection = await this.getCollection();

        if (await this.exists(food.id)) {
            return false;
        }

        await collection.insertOne(food.toDocument());

        return true;

    }

    async read() {

        const collection = await this.getCollection();
        const documents = await collection.find().toArray();

        return documents.map(document =>

            new Food(document._id,document.typeOfFood)
        );

    }

    async update(food) {

        const collection = await this.getCollection();
        const result = await collection.replaceOne({ _id: food.id },
            food.toDocument()
        );

        return result.modifiedCount > 0;

    }

    async delete(id) {

        const collection = await this.getCollection();
        const result = await collection.deleteOne({_id: id});

        return result.deletedCount > 0;

    }

    async findById(id) {

        const collection = await this.getCollection();
        const document = await collection.findOne({_id: id});

        if (!document) {
            return null;
        }

        return new Food(
            document._id,
            document.typeOfFood

        );

    }

    async exists(id) {

        const collection = await this.getCollection();
        const document = await collection.findOne({_id: id});

        return document != null;

    }

}

module.exports = FoodController;