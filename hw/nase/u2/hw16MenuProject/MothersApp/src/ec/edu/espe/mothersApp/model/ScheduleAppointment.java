/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mothersApp.model;

import java.util.Scanner;

/**
 *
 * @author Jennyfer Nase, Error 404, @ESPE
 */

public class ScheduleAppointment {

    private static String appointmentDate = "";
    private static String reminder = "";

    private static String doctorRecommendation = "";

    public static void scheduleAppointment(String date, String note) {
        appointmentDate = date;
        reminder = note;
        System.out.println("Appointment scheduled successfully.");
    }

    public static void showAppointments() {
        System.out.println("\n __________________________________");
        System.out.println("         APPOINTMENTS");
        System.out.println("___________________________________");

        if (appointmentDate.isEmpty()) {
            System.out.println("No appointment scheduled.");
        } else {
            System.out.println("Date: " + appointmentDate);
            System.out.println("Reminder: " + reminder);
        }

        System.out.println("________________________________");
    }

    public static void saveMedicalHistory(String recommendation) {
        doctorRecommendation = recommendation;
        System.out.println("Medical history saved successfully.");
    }

    public static void showMedicalHistory() {

        System.out.println("\n _____________________________________");
        System.out.println("         MEDICAL HISTORY");
        System.out.println("_____________________________________");
        
        System.out.println("DEBUG babyWeight: " + PediatricGrowthValidator.babyWeight);
        System.out.println("DEBUG motherWeight: " + PediatricGrowthValidator.motherWeight);

        if (ProfileManager.savedMother != null) {

            System.out.println("\nMOTHER INFORMATION");
            System.out.println("_____________________________________");

            System.out.println("Name: "
                    + ProfileManager.savedMother.firstName + " "
                    + ProfileManager.savedMother.lastName);

            System.out.println("ID: "
                    + ProfileManager.savedMother.id);

            System.out.println("Birth Date: "
                    + ProfileManager.savedMother.birthDate);

            System.out.println("Mother Weight: "
                    + PediatricGrowthValidator.motherWeight + " kg");

            System.out.println("Mother Height: "
                    + PediatricGrowthValidator.motherHeight + " cm");
        } else {
            System.out.println("\nNo mother data registered.");
        }

        if (ProfileManager.savedBaby != null) {

            System.out.println("\nBABY INFORMATION");
            System.out.println("_____________________________________");

            System.out.println("Name: "
                    + ProfileManager.savedBaby.firstName + " "
                    + ProfileManager.savedBaby.lastName);

            System.out.println("Expected/Birth Date: "
                    + ProfileManager.savedBaby.birthDate);

            System.out.println("Baby Weight: "
                    + PediatricGrowthValidator.babyWeight + " g");

            System.out.println("Baby Height: "
                    + PediatricGrowthValidator.babyHeight + " cm");

        } else {
            System.out.println("\nNo baby data registered.");
        }

        System.out.println("\nAPPOINTMENT");
        System.out.println("_____________________________________");

        if (!appointmentDate.isEmpty()) {
            System.out.println("Date: " + appointmentDate);
            System.out.println("Reminder: " + reminder);
        } else {
            System.out.println("No appointment scheduled.");
        }

        System.out.println("\nDOCTOR RECOMMENDATION");
        System.out.println("_____________________________________");

        if (!doctorRecommendation.isEmpty()) {
            System.out.println(doctorRecommendation);
        } else {
            System.out.println("No recommendation provided.");
        }

        System.out.println("_____________________________________");
    }
}