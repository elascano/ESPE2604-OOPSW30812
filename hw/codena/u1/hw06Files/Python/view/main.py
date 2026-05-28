from model.student import Student
from model.teacher import Teacher

from model.file_manager import (
    save_student_csv,
    save_teacher_csv,
    read_students_csv,
    read_teachers_csv,
    save_student_json,
    save_teacher_json,
    read_students_json,
    read_teachers_json
)

running = True

while running:

    print("\n=== MENU ===")
    print("1. Add Student")
    print("2. Add Teacher")
    print("3. Show Students CSV")
    print("4. Show Teachers CSV")
    print("5. Show Students JSON")
    print("6. Show Teachers JSON")
    print("7. Exit")

    option = int(input("Choose an option: "))

    match option:

        case 1:

            print("\n--- ENTER STUDENT DATA ---")

            s_id = int(input("ID: "))
            s_name = input("Name: ")
            s_course = input("Course: ")

            student = Student(
                s_id,
                s_name,
                s_course
            )

            save_student_csv(student)
            save_student_json(student)

            print("Student saved.")

        case 2:

            print("\n--- ENTER TEACHER DATA ---")

            t_id = int(input("ID: "))
            t_name = input("Name: ")
            t_career = input("Career: ")

            teacher = Teacher(
                t_id,
                t_name,
                t_career
            )

            save_teacher_csv(teacher)
            save_teacher_json(teacher)

            print("Teacher saved.")

        case 3:

            print("\n--- STUDENTS CSV ---")

            students = read_students_csv()

            for student in students:
                print(student)

        case 4:

            print("\n--- TEACHERS CSV ---")

            teachers = read_teachers_csv()

            for teacher in teachers:
                print(teacher)

        case 5:

            print("\n--- STUDENTS JSON ---")

            students = read_students_json()

            for student in students:
                print(student)

        case 6:

            print("\n--- TEACHERS JSON ---")

            teachers = read_teachers_json()

            for teacher in teachers:
                print(teacher)

        case 7:

            running = False

            print("Program finished.")

        case _:

            print("Invalid option.")