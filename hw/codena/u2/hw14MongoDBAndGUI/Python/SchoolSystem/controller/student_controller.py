from controller.database import Database

class StudentController:

    def __init__(self):
        self.database = Database()

    def save_student(self, student):

        self.database.students.insert_one({
            "id": student.student_id,
            "firstName": student.first_name,
            "lastName": student.last_name,
            "age": student.age
        })

    def search_student(self, student_id):
        query = self.database.students.find_one({"id": student_id})
        return query

    def update_student(self, student):

        self.database.students.update_one(
            {"id": student.student_id},
            {
                "$set": {
                    "firstName": student.first_name,
                    "lastName": student.last_name,
                    "age": student.age
                }
            }
        )

    def delete_student(self, student_id):

        self.database.students.delete_one({"id": student_id})