package ec.edu.espe.educativeapp.view;

import ec.edu.espe.educativeapp.model.FileManager;
import ec.edu.espe.educativeapp.model.Student;
import ec.edu.espe.educativeapp.model.Teacher;
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
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (option) {
                
                case 1:
                    
                    System.out.println("\n--- Enter Student Data ---");

                    System.out.print("ID: ");
                    int sId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Name: ");
                    String sName = scanner.nextLine();

                    System.out.print("Course: ");
                    String sCourse = scanner.nextLine();

                    Student student = new Student(sId, sName, sCourse);

                    FileManager.saveStudentCSV(student);
                    FileManager.saveStudentJSON(student);

                    System.out.println("Student saved");
                    break;
                    
                case 2:
                    
                    System.out.println("\n--- Enter Teacher Data ---");

                    System.out.print("ID: ");
                    int tId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Name: ");
                    String tName = scanner.nextLine();

                    System.out.print("Career: ");
                    String tCareer = scanner.nextLine();

                    Teacher teacher = new Teacher(tId, tName, tCareer);

                    FileManager.saveTeacherCSV(teacher);
                    FileManager.saveTeacherJSON(teacher);

                    System.out.println("Teacher saved");
                    break;

                case 3:
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
