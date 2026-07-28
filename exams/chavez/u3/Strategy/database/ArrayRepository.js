const MongoConnection = require("../database/MongoConnection");


class ArrayRepository {

    async save(model) {

        const db = await MongoConnection.connect();

        const collection = db.collection("arrays");

        await collection.insertOne({

            unsorted: model.getNumbers(),
            size: model.getSize(),
            algorithm: model.getAlgorithm(),
            sorted: model.getSortedNumbers()

        });

        console.log("Data saved successfully in MongoDB Atlas.");

    }

}


module.exports = ArrayRepository;