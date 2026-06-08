import json
import os
from model.student import Student

class JsonManager:
    def __init__(self):
        self.file_name = "student.json"
        self.students = self.load_students()

    def get_students(self):
        return self.students

    def add_student(self, student):
        self.students.append(student)
        self.save_students()

    def save_students(self):
        try:
            data = []
            for s in self.students:
                data.append({
                    "idNumber": s.get_id_number(),
                    "name": s.get_name(),
                    "age": s.get_age(),
                    "career": s.get_career(),
                    "grades": s.get_grades()
                })
            with open(self.file_name, 'w') as f:
                json.dump(data, f, indent=2)
        except Exception as e:
            print(f"Error saving file: {e}")

    def load_students(self):
        try:
            if os.path.exists(self.file_name):
                with open(self.file_name, 'r') as f:
                    data = json.load(f)
                    students = []
                    for item in data:
                        students.append(Student(
                            item["idNumber"],
                            item["name"],
                            item["age"],
                            item["career"],
                            item["grades"]
                        ))
                    return students
        except Exception as e:
            print(f"Error loading file: {e}")
        return []