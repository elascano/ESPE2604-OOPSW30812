const mongo = require("../database/mongo");

class CourseController {

    async saveCourse(course) {

        const db = await mongo.getDb();

        await db
            .collection("courses")
            .insertOne(course);

        console.log("Course Saved");
    }

    async searchCourse(id) {

        const db = await mongo.getDb();

        return await db
            .collection("courses")
            .findOne({ id });
    }

    async updateCourse(course) {

        const db = await mongo.getDb();

        await db
            .collection("courses")
            .updateOne(
                { id: course.id },
                {
                    $set: {
                        name: course.name,
                        teacher: course.teacher
                    }
                }
            );
    }

    async deleteCourse(id) {

        const db = await mongo.getDb();

        await db
            .collection("courses")
            .deleteOne({ id });
    }
}

module.exports = CourseController;