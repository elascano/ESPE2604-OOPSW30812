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

public class PediatricGrowthValidator {

    public static double motherWeight;
    public static double motherHeight;

    public static double babyWeight;
    public static double babyHeight;

    public static void validateGrowth() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n  ______  VALIDATE PEDIATRIC GROWTH ______   ");

        System.out.print("Enter baby weight (g): ");
        babyWeight = sc.nextDouble();

        System.out.print("Enter baby height (cm): ");
        babyHeight = sc.nextDouble();

        System.out.print("Enter mother's weight (kg): ");
        motherWeight = sc.nextDouble();

        System.out.print("Enter mother's height (cm): ");
        motherHeight = sc.nextDouble();

        showResult(babyWeight, babyHeight);
    }

    public static void showResult(double weight, double size) {

        System.out.println("\n  RESULTS  ");

        if (weight >= 2500 && size >= 45) {
            System.out.println("Growth Status: NORMAL");
        } else if (weight >= 1800 && size >= 35) {
            System.out.println("Growth Status: LOW RISK");
        } else {
            System.out.println("Growth Status: SEVERE");
        }
    }
}