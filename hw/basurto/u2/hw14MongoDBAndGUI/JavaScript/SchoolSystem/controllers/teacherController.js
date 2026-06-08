const mongo = require("../database/mongo");

class TeacherController {

    async saveTeacher(teacher) {

        const db = await mongo.getDb();

        await db
            .collection("teachers")
            .insertOne(teacher);

        console.log("Teacher Saved");
    }

    async searchTeacher(id) {

        const db = await mongo.getDb();

        return await db
            .collection("teachers")
            .findOne({ id });
    }

    async updateTeacher(teacher) {

        const db = await mongo.getDb();

        await db
            .collection("teachers")
            .updateOne(
                { id: teacher.id },
                {
                    $set: {
                        name: teacher.name,
                        subject: teacher.subject
                    }
                }
            );
    }

    async deleteTeacher(id) {

        const db = await mongo.getDb();

        await db
            .collection("teachers")
            .deleteOne({ id });
    }
}

module.exports = TeacherController;