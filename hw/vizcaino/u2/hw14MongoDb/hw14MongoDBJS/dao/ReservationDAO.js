const { getDatabase } =
require("../config/mongoConnection");

class ReservationDAO {

    async save(reservation) {

        const db =
        await getDatabase();

        await db
        .collection("reservations")
        .insertOne(reservation);
    }

    async findAll() {

        const db =
        await getDatabase();

        return await db
        .collection("reservations")
        .find()
        .toArray();
    }

    async delete(id) {

        const db =
        await getDatabase();

        await db
        .collection("reservations")
        .deleteOne({ id });
    }
}

module.exports =
new ReservationDAO();