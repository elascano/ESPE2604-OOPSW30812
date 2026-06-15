from model.grade import Grade
from controller.json_manager import JsonManager
from model.student import Student


class StudentController:
    def __init__(self):
        self.students = JsonManager.load_students()
        self.grades = JsonManager.load_grades()

    def register_student(self, student_id, first_name, last_name, phone_number):
        new_student = Student(student_id, first_name, last_name, phone_number)
        self.students.append(new_student)
        JsonManager.save_students(self.students)

    def find_student_by_id(self, student_id):
        for student in self.students:
            if student.id.lower() == student_id.lower():
                return student
        return None

    def add_grades_to_student(self, student_id, values):
        student = self.find_student_by_id(student_id)
        if student is None:
            return False

        for value in values:
            if value < 0 or value > 20:
                print("Error: All grades must be between 0 and 20.")
                return False

        for value in values:
            self.grades.append(Grade(student_id, value))

        JsonManager.save_grades(self.grades)
        return True

    def get_grades_by_student(self, student_id):
        return [grade.value for grade in self.grades if grade.student_id.lower() == student_id.lower()]

    def calculate_average(self, student_id):
        student_grades = self.get_grades_by_student(student_id)
        if not student_grades:
            return 0.0
        return sum(student_grades) / len(student_grades)

    def get_all_students(self):
        self.students = JsonManager.load_students()
        self.grades = JsonManager.load_grades()
        return self.students
