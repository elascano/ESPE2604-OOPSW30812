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
public class AlarmValidator {

    public void classifyRiskLevel() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n  HEALTH RISK CLASSIFIER  ");

        System.out.print("Enter baby temperature (°C): ");
        double temperature = sc.nextDouble();

        sc.nextLine();

        System.out.print("Respiratory distress? (yes/no): ");
        String respiratory = sc.nextLine();

        System.out.print("Feeding problems? (yes/no): ");
        String feeding = sc.nextLine();

        System.out.print("Abnormal skin color? (yes/no): ");
        String skin = sc.nextLine();

        System.out.print("Lethargy or inconsolable crying? (yes/no): ");
        String activity = sc.nextLine();

        boolean danger = false;

        if (temperature > 38 || temperature < 35.5) {
            danger = true;
            System.out.println("WARNING: Abnormal temperature.");
        }

        if (respiratory.equalsIgnoreCase("yes")) {
            danger = true;
            System.out.println("WARNING: Respiratory distress detected.");
        }

        if (feeding.equalsIgnoreCase("yes")) {
            danger = true;
            System.out.println("WARNING: Feeding problem detected.");
        }

        if (skin.equalsIgnoreCase("yes")) {
            danger = true;
            System.out.println("WARNING: Skin color abnormality detected.");
        }

        if (activity.equalsIgnoreCase("yes")) {
            danger = true;
            System.out.println("WARNING: Dangerous activity level detected.");
        }

        System.out.println("\n____ FINAL RESULT ____ ");

        if (danger) {

            System.out.println("CRITICAL RISK!");
            System.out.println("Immediate hospital attention required.");

        } else {

            System.out.println("Baby condition appears NORMAL.");
        }
    }
}