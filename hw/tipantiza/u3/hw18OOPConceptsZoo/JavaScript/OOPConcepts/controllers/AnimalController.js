const { connect } = require("../config/mongo");

const Chicken = require("../models/Chicken");
const Cow = require("../models/Cow");
const Pig = require("../models/Pig");
const Sheep = require("../models/Sheep");

class AnimalController {

    constructor() {
        this.collectionName = "animals";
    }

    async getCollection() {
        const database = await connect();
        console.log(database);
        return database.collection(this.collectionName);
    }

    async create(animal) {
        const collection = await this.getCollection();

        if (await this.exists(animal.id)) {
            return false;
        }

        await collection.insertOne(animal.toDocument());

        return true;

    }

    async read() {

        const collection = await this.getCollection();
        const documents = await collection.find().toArray();
        return documents.map(document => this.documentToAnimal(document));

    }

    async update(animal) {

        const collection = await this.getCollection();
        const result = await collection.replaceOne({ _id: animal.id },animal.toDocument());

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

        return this.documentToAnimal(document);

    }

    async exists(id) {

        const collection = await this.getCollection();
        const document = await collection.findOne({_id: id});

        return document != null;

    }

    documentToAnimal(document) {

        const id = document._id;
        const type = document.type;
        const breed = document.breed;
        const bornOnDate = document.bornOnDate;
        const weight = document.weight;

        switch (type) {

            case "Chicken":

                return new Chicken(
                    id,
                    breed,
                    bornOnDate,
                    weight,
                    document.isMolting,
                    document.numberOfEggs
                );

            case "Cow":

                return new Cow(
                    id,
                    breed,
                    bornOnDate,
                    weight,
                    document.isProducingMilk

                );

            case "Pig":

                return new Pig(
                    id,
                    breed,
                    bornOnDate,
                    weight,
                    document.idealWeight

                );

            case "Sheep":

                return new Sheep(
                    id,
                    breed,
                    bornOnDate,
                    weight,
                    document.lastShearing

                );

            default:

                return null;

        }

    }

}

module.exports = AnimalController;