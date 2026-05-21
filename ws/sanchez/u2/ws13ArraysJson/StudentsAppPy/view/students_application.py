import sys
import os

# Agregar la ruta del proyecto al path de Python
sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from model.student import Student
from model.json_manager import JsonManager

class StudentsApplication:
    def __init__(self):
        self.students = JsonManager.read_students()

    def show_menu(self):
        print("\n===== STUDENT MENU =====")
        print("1. Display JSON data")
        print("2. Enter student data")
        print("3. Reload JSON file")
        print("4. Calculate average (select student)")
        print("5. Exit")
        print("Choose: ", end="")

    def add_student(self):
        first_name = input("First Name: ")
        last_name = input("Last Name: ")
        subject = input("Subject: ")
        age = int(input("Age: "))

        grades = []
        for i in range(1, 4):
            while True:
                grade = int(input(f"Grade {i} (0-20): "))
                if 0 <= grade <= 20:
                    grades.append(grade)
                    break
                print("Grade must be between 0 and 20")

        self.students.append(Student(first_name, last_name, subject, age, grades))
        JsonManager.save_students(self.students)
        print("Student added successfully!")

    def display_json(self):
        if not self.students:
            print("No students found.")
            return

        print("\n===== STUDENTS =====")
        for i, student in enumerate(self.students):
            print(f"\nStudent #{i + 1}")
            print(student)

    def read_json(self):
        self.students = JsonManager.read_students()
        print("File reloaded successfully.")

    def calculate_average_by_student(self):
        if not self.students:
            print("No students available.")
            return

        print("\nSelect student:")
        for i, student in enumerate(self.students):
            print(f"{i + 1}. {student.get_first_name()} {student.get_last_name()}")

        try:
            index = int(input("Enter number: ")) - 1
            if 0 <= index < len(self.students):
                student = self.students[index]
                print(f"Average of {student.get_first_name()}: {student.get_average():.2f}")
            else:
                print("Invalid student selection.")
        except ValueError:
            print("Invalid input. Please enter a number.")

    def run(self):
        while True:
            self.show_menu()
            try:
                option = int(input())
                if option == 1:
                    self.display_json()
                elif option == 2:
                    self.add_student()
                elif option == 3:
                    self.read_json()
                elif option == 4:
                    self.calculate_average_by_student()
                elif option == 5:
                    print("Exiting...")
                    break
                else:
                    print("Invalid option")
            except ValueError:
                print("Please enter a valid number")

if __name__ == "__main__":
    app = StudentsApplication()
    app.run()