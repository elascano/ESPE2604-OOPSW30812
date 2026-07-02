const { connect } = require("../config/mongo");

const Cut = require("../models/Cut");

class CutController {

    constructor() {

        this.collectionName = "cuts";

    }

    async getCollection() {
        const database = await connect();
        return database.collection(this.collectionName);

    }

    async create(cut) {

        const collection = await this.getCollection();
        if (await this.exists(cut.id)) {
            return false;
        }

        await collection.insertOne(cut.toDocument());

        return true;

    }

    async read() {

        const collection = await this.getCollection();
        const documents = await collection.find().toArray();

        return documents.map(document =>

            new Cut(
                document._id,
                document.description,
                document.procedure,
                document.weight
            )

        );

    }

    async update(cut) {

        const collection = await this.getCollection();

        const result = await collection.replaceOne(
            { _id: cut.id },
            cut.toDocument()
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

        return new Cut(
            document._id,
            document.description,
            document.procedure,
            document.weight
        );

    }

    async exists(id) {

        const collection = await this.getCollection();
        const document = await collection.findOne({_id: id});

        return document != null;

    }

}

module.exports = CutController;