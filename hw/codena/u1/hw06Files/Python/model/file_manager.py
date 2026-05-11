import csv
import json
import os

from model.student import Student
from model.teacher import Teacher


# SAVE STUDENT CSV
def save_student_csv(student):

    with open("students.csv", "a", newline="") as file:

        writer = csv.writer(file)

        writer.writerow([
            student.id,
            student.name,
            student.course
        ])


# SAVE TEACHER CSV
def save_teacher_csv(teacher):

    with open("teachers.csv", "a", newline="") as file:

        writer = csv.writer(file)

        writer.writerow([
            teacher.id,
            teacher.name,
            teacher.career
        ])


# READ STUDENTS CSV
def read_students_csv():

    students = []

    if not os.path.exists("students.csv"):
        return students

    with open("students.csv", "r") as file:

        reader = csv.reader(file)

        for row in reader:

            student = Student(
                int(row[0]),
                row[1],
                row[2]
            )

            students.append(student)

    return students


# READ TEACHERS CSV
def read_teachers_csv():

    teachers = []

    if not os.path.exists("teachers.csv"):
        return teachers

    with open("teachers.csv", "r") as file:

        reader = csv.reader(file)

        for row in reader:

            teacher = Teacher(
                int(row[0]),
                row[1],
                row[2]
            )

            teachers.append(teacher)

    return teachers


# SAVE STUDENT JSON
def save_student_json(student):

    students_data = []

    if os.path.exists("students.json"):

        with open("students.json", "r") as file:

            try:
                students_data = json.load(file)

            except json.JSONDecodeError:
                students_data = []

    students_data.append(student.to_dict())

    with open("students.json", "w") as file:

        json.dump(students_data, file, indent=4)


# SAVE TEACHER JSON
def save_teacher_json(teacher):

    teachers_data = []

    if os.path.exists("teachers.json"):

        with open("teachers.json", "r") as file:

            try:
                teachers_data = json.load(file)

            except json.JSONDecodeError:
                teachers_data = []

    teachers_data.append(teacher.to_dict())

    with open("teachers.json", "w") as file:

        json.dump(teachers_data, file, indent=4)


# READ STUDENTS JSON
def read_students_json():

    students = []

    if not os.path.exists("students.json"):
        return students

    with open("students.json", "r") as file:

        data = json.load(file)

        for item in data:

            student = Student(
                item["id"],
                item["name"],
                item["course"]
            )

            students.append(student)

    return students

# READ TEACHERS JSON
def read_teachers_json():

    teachers = []

    if not os.path.exists("teachers.json"):
        return teachers

    with open("teachers.json", "r") as file:

        data = json.load(file)

        for item in data:

            teacher = Teacher(
                item["id"],
                item["name"],
                item["career"]
            )

            teachers.append(teacher)

    return teachers