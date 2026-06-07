from controller.database import Database

class TeacherController:

    def __init__(self):
        self.database = Database()

    def save_teacher(self, teacher):

        self.database.teachers.insert_one({
            "id": teacher.teacher_id,
            "name": teacher.name,
            "subject": teacher.subject
        })

    def search_teacher(self, teacher_id):
        query = self.database.teachers.find_one({"id": teacher_id})
        return query
        

    def update_teacher(self, teacher):

        self.database.teachers.update_one(
            {"id": teacher.teacher_id},
            {
                "$set": {
                    "name": teacher.name,
                    "subject": teacher.subject
                }
            }
        )

    def delete_teacher(self, teacher_id):

        self.database.students.delete_one({"id": teacher_id})