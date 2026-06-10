/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mothersApp.model;
import java.util.Scanner;

/**
 * @author Jennyfer Nase, Error 404, @ESPE
 */

public class MedicalHistory {

    public void showMedicalHistory() {

        Scanner sc = new Scanner(System.in);

        System.out.println("______ MEDICAL HISTORY ______ ");

        System.out.print("Mother Name: ");
        String motherName = sc.nextLine();

        System.out.print("Baby Name (if born): ");
        String babyName = sc.nextLine();

        System.out.print("Expected birth date (if not born): ");
        String expectedDate = sc.nextLine();

        System.out.print("Medical appointment date: ");
        String appointmentDate = sc.nextLine();

        System.out.print("Doctor recommendation: ");
        String recommendation = sc.nextLine();

        System.out.print("Mother Weight (kg): ");
        double motherWeight = sc.nextDouble();

        System.out.print("Mother Height (cm): ");
        double motherHeight = sc.nextDouble();

        System.out.print("Baby Weight (grams): ");
        int babyWeight = sc.nextInt();

        System.out.print("Baby Height (cm): ");
        int babyHeight = sc.nextInt();

        System.out.println("______  HISTORY SUMMARY ______ ");

        System.out.println("Mother: " + motherName);
        System.out.println("Baby: " + babyName);
        System.out.println("Expected/Birth Date: " + expectedDate);
        System.out.println("Appointment: " + appointmentDate);
        System.out.println("Recommendation: " + recommendation);
        System.out.println("Mother Weight: " + motherWeight + " kg");
        System.out.println("Mother Height: " + motherHeight + " cm");
        System.out.println("Baby Weight: " + babyWeight + " g");
        System.out.println("Baby Height: " + babyHeight + " cm");
    }
}
