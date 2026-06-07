const mongo = require("../database/mongo");

class StudentController {

    async saveStudent(student) {

        const db = await mongo.getDb();

        await db
            .collection("students")
            .insertOne(student);

        console.log("Student Saved");
    }

    async searchStudent(id) {

        const db = await mongo.getDb();

        return await db
            .collection("students")
            .findOne({ id });
    }

    async updateStudent(student) {

        const db = await mongo.getDb();

        await db
            .collection("students")
            .updateOne(
                { id: student.id },
                {
                    $set: {
                        firstName: student.firstName,
                        lastName: student.lastName,
                        age: student.age
                    }
                }
            );
    }

    async deleteStudent(id) {

        const db = await mongo.getDb();

        await db
            .collection("students")
            .deleteOne({ id });
    }
}

module.exports = StudentController;