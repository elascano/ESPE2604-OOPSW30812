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

public class MedicalRecord {

    public void monitorWarningSigns() {

        Scanner sc = new Scanner(System.in);

        String answer;

        System.out.println("\n  ______ WARNING SIGNS MONITOR______  ");

        System.out.print("Do you have fever? (yes/no): ");
        answer = sc.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Recommendation: Drink water and visit a doctor.\n");
        }

        System.out.print("Do you have bleeding? (yes/no): ");
        answer = sc.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Recommendation: Go immediately to the emergency room.\n");
        }

        System.out.print("Do you have severe headache? (yes/no): ");
        answer = sc.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Recommendation: Check your blood pressure.\n");
        }

        System.out.print("Do you feel reduced baby movement? (yes/no): ");
        answer = sc.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Recommendation: Contact your doctor immediately.\n");
        }

        System.out.print("Do you have high blood pressure? (yes/no): ");
        answer = sc.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Recommendation: Rest and seek medical help.\n");
        }

        System.out.print("Do you have difficulty breathing? (yes/no): ");
        answer = sc.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Recommendation: Go to the hospital immediately.\n");
        }
    }
}