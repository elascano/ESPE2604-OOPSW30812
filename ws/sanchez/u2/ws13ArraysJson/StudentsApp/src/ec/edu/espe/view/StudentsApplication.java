/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.view;

/**
 *
 * @author Joel Sanchez <The_Softwarriors at ESPE>
 */
import ec.edu.espe.model.JsonManager;
import ec.edu.espe.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentsApplication {

    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<Student> students = JsonManager.readStudents();

    public static void main(String[] args) {

        int option;

        do {
            showMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1 -> displayJson();
                case 2 -> addStudent();
                case 3 -> readJson();
                case 4 -> calculateAverageByStudent();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option");
            }

        } while (option != 5);
    }

    private static void showMenu() {
        System.out.println("\n===== STUDENT MENU =====");
        System.out.println("1. Display JSON data");
        System.out.println("2. Enter student data");
        System.out.println("3. Reload JSON file");
        System.out.println("4. Calculate average (select student)");
        System.out.println("5. Exit");
        System.out.print("Choose: ");
    }

    private static void addStudent() {

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Subject: ");
        String subject = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();

        ArrayList<Integer> grades = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {

            int grade;
            do {
                System.out.print("Grade " + i + " (0-20): ");
                grade = scanner.nextInt();
            } while (grade < 0 || grade > 20);

            grades.add(grade);
        }

        scanner.nextLine();

        students.add(new Student(firstName, lastName, subject, age, grades));
        JsonManager.saveStudents(students);

        System.out.println("Student added successfully!");
    }

    private static void displayJson() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n===== STUDENTS =====");

        for (int i = 0; i < students.size(); i++) {
            System.out.println("\nStudent #" + (i + 1));
            System.out.println(students.get(i));
        }
    }

    private static void readJson() {
        students = JsonManager.readStudents();
        System.out.println("File reloaded successfully.");
    }

    private static void calculateAverageByStudent() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\nSelect student:");

        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " +
                    students.get(i).getFirstName() + " " +
                    students.get(i).getLastName());
        }

        System.out.print("Enter number: ");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < students.size()) {

            Student s = students.get(index);

            System.out.printf(
                    "Average of %s: %.2f%n",
                    s.getFirstName(),
                    s.getAverage()
            );

        } else {
            System.out.println("Invalid student selection.");
        }
    }
}