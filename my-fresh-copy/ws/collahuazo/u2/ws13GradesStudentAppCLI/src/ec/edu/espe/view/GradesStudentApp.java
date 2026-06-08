package ec.edu.espe.view;

import ec.edu.espe.controller.StudentController;
import ec.edu.espe.model.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class GradesStudentApp {

    public static void main(String[] args) {
        StudentController controller = new StudentController();
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("\n==================================");
            System.out.println("       STUDENT GRADES SYSTEM      ");
            System.out.println("==================================");
            System.out.println("1. Register Student");
            System.out.println("2. Input Grades (Option A)");
            System.out.println("3. Grades and Students Report");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (option) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();

                    controller.registerStudent(id, firstName, lastName, phone);
                    System.out.println("Student registered successfully!");
                    break;

                case 2:
                    System.out.println("\n--- Registered Students ---");
                    if (controller.getAllStudents().isEmpty()) {
                        System.out.println("No students found. Register one first.");
                        break;
                    }

                    for (Student s : controller.getAllStudents()) {
                        System.out.println("ID: " + s.getId() + " | Name: " + s.getFirstName() + " " + s.getLastName());
                    }

                    System.out.print("\nEnter the ID of the student to add grades: ");
                    String targetId = scanner.nextLine();

                    if (controller.findStudentById(targetId) == null) {
                        System.out.println("Student ID not found.");
                        break;
                    }

                    ArrayList<Double> temporaryGradesList = new ArrayList<>();
                    boolean inputError = false;

                    for (int i = 1; i <= 3; i++) {
                        System.out.print("Enter grade " + i + " (0 - 20): ");
                        try {
                            double gradeValue = Double.parseDouble(scanner.nextLine());
                            temporaryGradesList.add(gradeValue);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid grade format. Input cancelled.");
                            inputError = true;
                            break;
                        }
                    }

                    if (!inputError) {
                        if (controller.addGradesToStudent(targetId, temporaryGradesList)) {
                            System.out.println("All 3 grades added successfully!");
                        } else {
                            System.out.println("Grades could not be saved due to validation rules.");
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n+------------+-----------------+-----------------+---------------------------+---------+-----------+");
                    System.out.printf("| %-10s | %-15s | %-15s | %-25s | %-7s | %-9s |\n", "ID", "First Name", "Last Name", "Grades", "Average", "Status");
                    System.out.println("+------------+-----------------+-----------------+---------------------------+---------+-----------+");

                    if (controller.getAllStudents().isEmpty()) {
                        System.out.printf("| %-92s |\n", "No data available");
                    } else {
                        for (Student s : controller.getAllStudents()) {
                            ArrayList<Double> studentGrades = controller.getGradesByStudent(s.getId());
                            double avg = controller.calculateAverage(s.getId());
                            String status = (avg >= 14.0) ? "Pass" : "No pass";
                            String gradesStr = studentGrades.toString();

                            System.out.printf("| %-10s | %-15s | %-15s | %-25s | %-7.2f | %-9s |\n",
                                    s.getId(),
                                    s.getFirstName(),
                                    s.getLastName(),
                                    gradesStr,
                                    avg,
                                    status);
                        }
                    }
                    System.out.println("+------------+-----------------+-----------------+---------------------------+---------+-----------+");
                    break;

                case 4:
                    System.out.println("Exiting the program... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 4);

        scanner.close();
    }
}
