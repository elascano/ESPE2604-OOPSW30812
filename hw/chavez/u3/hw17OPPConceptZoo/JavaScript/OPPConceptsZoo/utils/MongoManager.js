import { connect } from "./MongoConnection.js";

export default class MongoManager {

    async saveAnimal(animal) {

        const database = await connect();

        const collection =
            database.collection("animals");

        await collection.insertOne({

            id: animal.id,
            breed: animal.breed,
            bornOn: animal.bornOn,
            weight: animal.weight

        });

        console.log(
            "Animal saved successfully"
        );
    }

    async saveFood(food) {

        const database = await connect();

        const collection =
            database.collection("food");

        await collection.insertOne({

            id: food.id,
            description: food.description

        });

        console.log(
            "Food saved successfully"
        );
    }

}