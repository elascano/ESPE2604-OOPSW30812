package ec.edu.espe.educativeapp.view;

import ec.edu.espe.educativeapp.model.FileManager;
import ec.edu.espe.educativeapp.model.Student;
import ec.edu.espe.educativeapp.model.Teacher;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */

public class ManageFilesEducativeApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("\n=== MENU ===");
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Show Students CSV");
            System.out.println("4. Show Teachers CSV");
            System.out.println("5. Show Students JSON");
            System.out.println("6. Show Teachers JSON");
            System.out.println("7. Exit");

            System.out.print("Choose an option: ");

            int option = scanner.nextInt();

            scanner.nextLine();

            switch (option) {

                case 1:

                    System.out.println("\n--- ENTER STUDENT DATA ---");

                    System.out.print("ID: ");
                    int sId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Name: ");
                    String sName = scanner.nextLine();

                    System.out.print("Course: ");
                    String sCourse = scanner.nextLine();

                    Student student =
                            new Student(sId, sName, sCourse);

                    FileManager.saveStudentCSV(student);
                    FileManager.saveStudentJSON(student);

                    System.out.println("Student saved.");

                    break;

                case 2:

                    System.out.println("\n--- ENTER TEACHER DATA ---");

                    System.out.print("ID: ");
                    int tId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Name: ");
                    String tName = scanner.nextLine();

                    System.out.print("Career: ");
                    String tCareer = scanner.nextLine();

                    Teacher teacher =
                            new Teacher(tId, tName, tCareer);

                    FileManager.saveTeacherCSV(teacher);
                    FileManager.saveTeacherJSON(teacher);

                    System.out.println("Teacher saved.");

                    break;

                case 3:

                    System.out.println("\n--- STUDENTS CSV ---");

                    List<Student> studentsCSV =
                            FileManager.readStudentsCSV();

                    for (Student s : studentsCSV) {
                        System.out.println(s);
                    }

                    break;

                case 4:

                    System.out.println("\n--- TEACHERS CSV ---");

                    List<Teacher> teachersCSV =
                            FileManager.readTeachersCSV();

                    for (Teacher t : teachersCSV) {
                        System.out.println(t);
                    }

                    break;

                case 5:

                    System.out.println("\n--- STUDENTS JSON ---");

                    List<Student> studentsJSON =
                            FileManager.readStudentsJSON();

                    for (Student s : studentsJSON) {
                        System.out.println(s);
                    }

                    break;

                case 6:

                    System.out.println("\n--- TEACHERS JSON ---");

                    List<Teacher> teachersJSON =
                            FileManager.readTeachersJSON();

                    for (Teacher t : teachersJSON) {
                        System.out.println(t);
                    }

                    break;

                case 7:

                    running = false;

                    System.out.println("Program finished.");

                    break;

                default:

                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}