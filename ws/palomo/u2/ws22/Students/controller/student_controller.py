from model.student import Student


class StudentController:

    def __init__(self):
        self.students = []

    def create_student(self, student):
        self.students.append(student)

    def get_all_students(self):
        return self.students

    def find_student(self, student_id):

        for student in self.students:
            if student.student_id == student_id:
                return student

        return None

    def delete_student(self, student_id):

        student = self.find_student(student_id)

        if student:
            self.students.remove(student)
            return True

        return False

    def update_student(self, student_id, name, grade1, grade2):

        student = self.find_student(student_id)

        if student:
            student.name = name
            student.grade1 = grade1
            student.grade2 = grade2
            return True

        return False