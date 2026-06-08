const { getDatabase } =
require("../config/mongoConnection");

class BackupDAO {

    async save(backup) {

        const db =
        await getDatabase();

        await db
        .collection("backups")
        .insertOne(backup);
    }

    async findAll() {

        const db =
        await getDatabase();

        return await db
        .collection("backups")
        .find()
        .toArray();
    }

    async delete(id) {

        const db =
        await getDatabase();

        await db
        .collection("backups")
        .deleteOne({ id });
    }
}

module.exports =
new BackupDAO();