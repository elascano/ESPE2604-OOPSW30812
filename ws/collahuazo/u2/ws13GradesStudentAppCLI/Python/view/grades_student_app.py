from controller.student_controller import StudentController


class GradesStudentApp:
    def __init__(self):
        self.controller = StudentController()

    def main(self):
        while True:
            print("\n==================================")
            print("       STUDENT GRADES SYSTEM      ")
            print("==================================")
            print("1. Register Student")
            print("2. Input Grades (Option A)")
            print("3. Grades and Students Report")
            print("4. Exit")

            option = input("Select an option: ").strip()
            if not option.isdigit():
                print("Invalid input. Please enter a number.")
                continue

            option = int(option)

            if option == 1:
                student_id = input("Enter ID: ").strip()
                first_name = input("Enter First Name: ").strip()
                last_name = input("Enter Last Name: ").strip()
                phone = input("Enter Phone Number: ").strip()
                self.controller.register_student(student_id, first_name, last_name, phone)
                print("Student registered successfully!")

            elif option == 2:
                students = self.controller.get_all_students()
                print("\n--- Registered Students ---")
                if not students:
                    print("No students found. Register one first.")
                    continue

                for student in students:
                    print(f"ID: {student.id} | Name: {student.first_name} {student.last_name}")

                target_id = input("\nEnter the ID of the student to add grades: ").strip()
                if self.controller.find_student_by_id(target_id) is None:
                    print("Student ID not found.")
                    continue

                temporary_grades = []
                input_error = False
                for i in range(1, 4):
                    grade_input = input(f"Enter grade {i} (0 - 20): ").strip()
                    try:
                        grade_value = float(grade_input)
                        temporary_grades.append(grade_value)
                    except ValueError:
                        print("Invalid grade format. Input cancelled.")
                        input_error = True
                        break

                if not input_error:
                    if self.controller.add_grades_to_student(target_id, temporary_grades):
                        print("All 3 grades added successfully!")
                    else:
                        print("Grades could not be saved due to validation rules.")

            elif option == 3:
                students = self.controller.get_all_students()
                print("\n+------------+-----------------+-----------------+---------------------------+---------+-----------+")
                print("| %-10s | %-15s | %-15s | %-25s | %-7s | %-9s |" % ("ID", "First Name", "Last Name", "Grades", "Average", "Status"))
                print("+------------+-----------------+-----------------+---------------------------+---------+-----------+")

                if not students:
                    print("| %-92s |" % "No data available")
                else:
                    for student in students:
                        student_grades = self.controller.get_grades_by_student(student.id)
                        avg = self.controller.calculate_average(student.id)
                        status = "Pass" if avg >= 14.0 else "No pass"
                        grades_str = str(student_grades)
                        print("| %-10s | %-15s | %-15s | %-25s | %-7.2f | %-9s |" % (
                            student.id,
                            student.first_name,
                            student.last_name,
                            grades_str,
                            avg,
                            status,
                        ))

                print("+------------+-----------------+-----------------+---------------------------+---------+-----------+")

            elif option == 4:
                print("Exiting the program... Goodbye!")
                break

            else:
                print("Invalid option. Try again.")


if __name__ == "__main__":
    GradesStudentApp().main()
