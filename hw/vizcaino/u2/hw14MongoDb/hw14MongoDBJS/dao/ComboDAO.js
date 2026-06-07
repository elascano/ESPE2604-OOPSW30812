const { getDatabase } =
require("../config/mongoConnection");

class ComboDAO {

    async save(combo) {

        const db =
        await getDatabase();

        await db
        .collection("combos")
        .insertOne(combo);
    }

    async findAll() {

        const db =
        await getDatabase();

        return await db
        .collection("combos")
        .find()
        .toArray();
    }

    async delete(id) {

        const db =
        await getDatabase();

        await db
        .collection("combos")
        .deleteOne({ id });
    }
}

module.exports =
new ComboDAO();