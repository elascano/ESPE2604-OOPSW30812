const getDatabase = require("./mongoManager");

class FarmAnimalDAO {

    async saveAnimal(animal) {

        const db = await getDatabase();

        await db.collection("animals").insertOne({
            id: animal.id,
            breed: animal.breed,
            weight: animal.weight,
            type: animal.constructor.name
        });

        console.log("Animal saved successfully.");
    }

    async getAnimals() {

        const db = await getDatabase();

        return await db.collection("animals").find().toArray();
    }

}

module.exports = FarmAnimalDAO;