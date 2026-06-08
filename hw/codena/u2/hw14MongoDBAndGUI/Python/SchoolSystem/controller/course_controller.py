from controller.database import Database

class CourseController:

    def __init__(self):
        self.database = Database()

    def save_course(self, course):

        self.database.courses.insert_one({
            "id": course.course_id,
            "name": course.name,
            "teacher": course.teacher
        })

    def search_course(self, course_id):
        query = self.database.courses.find_one({"id": course_id})
        return query
        

    def update_course(self, course):

        self.database.courses.update_one(
            {"id": course.course_id},
            {
                "$set": {
                    "name": course.name,
                    "teacher": course.teacher
                }
            }
        )

    def delete_course(self, course_id):

        self.database.courses.delete_one({"id": course_id})