import json
import os
from model.student import Student

FILE_NAME = "student.json"

class JsonManager:
    @staticmethod
    def save_students(students):
        try:
            data = []
            for student in students:
                data.append({
                    "first_name": student.get_first_name(),
                    "last_name": student.get_last_name(),
                    "subject": student.get_subject(),
                    "age": student.get_age(),
                    "grades": student.get_grades()
                })
            
            with open(FILE_NAME, "w", encoding="utf-8") as file:
                json.dump(data, file, indent=4, ensure_ascii=False)
            print("\nData saved successfully!")
        except Exception as e:
            print(f"Error saving file: {e}")

    @staticmethod
    def read_students():
        if not os.path.exists(FILE_NAME):
            return []

        try:
            with open(FILE_NAME, "r", encoding="utf-8") as file:
                data = json.load(file)
                students = []
                for item in data:
                    student = Student(
                        item.get("first_name", ""),
                        item.get("last_name", ""),
                        item.get("subject", ""),
                        item.get("age", 0),
                        item.get("grades", [])
                    )
                    students.append(student)
                return students
        except Exception as e:
            print(f"No file found or error reading file: {e}")
            return []