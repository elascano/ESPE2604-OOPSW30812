import json
from pathlib import Path

from model.grade import Grade
from model.student import Student

ROOT_PATH = Path(__file__).resolve().parents[1]
STUDENTS_FILE = ROOT_PATH / "students.json"
GRADES_FILE = ROOT_PATH / "grades.json"


class JsonManager:
    @staticmethod
    def save_students(students):
        with open(STUDENTS_FILE, "w", encoding="utf-8") as file:
            json.dump([student.to_dict() for student in students], file, indent=4, ensure_ascii=False)

    @staticmethod
    def load_students():
        if not STUDENTS_FILE.exists():
            return []
        with open(STUDENTS_FILE, "r", encoding="utf-8") as file:
            data = json.load(file)
            return [Student.from_dict(item) for item in data if isinstance(item, dict)]

    @staticmethod
    def save_grades(grades):
        with open(GRADES_FILE, "w", encoding="utf-8") as file:
            json.dump([grade.to_dict() for grade in grades], file, indent=4, ensure_ascii=False)

    @staticmethod
    def load_grades():
        if not GRADES_FILE.exists():
            return []
        with open(GRADES_FILE, "r", encoding="utf-8") as file:
            data = json.load(file)
            return [Grade.from_dict(item) for item in data if isinstance(item, dict)]
