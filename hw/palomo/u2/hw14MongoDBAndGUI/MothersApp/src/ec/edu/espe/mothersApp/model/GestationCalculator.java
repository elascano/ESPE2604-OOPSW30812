/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mothersApp.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author Jennyfer Nase, Error 404, @ESPE
 */

public class GestationCalculator {

    Scanner sc = new Scanner(System.in);

    public void calculateFromLMP() {

        System.out.print("Enter Date of Last Menstrual Period (YYYY-MM-DD): ");
        String lmp = sc.nextLine();

        LocalDate lmpDate = LocalDate.parse(lmp);

        long currentWeek = ChronoUnit.WEEKS.between(lmpDate, LocalDate.now());
        LocalDate dueDate = lmpDate.plusWeeks(40);

        String trimester = getTrimester((int) currentWeek);

        System.out.println("\n-------------------------------------------");
        System.out.println("RESULT: WEEK " + currentWeek + " OF PREGNANCY");
        System.out.println("TRIMESTER: " + trimester);
        System.out.println(" ESTIMATED DUE DATE (FPP): " + dueDate);
    }

    public void calculateFromWeek() {

        int week;

        while (true) {
            System.out.print("Enter current week: ");
            week = sc.nextInt();

            if (week >= 1 && week <= 40) {
                break;
            }
            System.out.println("ERROR: Week must be between 1 and 40.");
        }

        int remainingWeeks = 40 - week;
        LocalDate dueDate = LocalDate.now().plusWeeks(remainingWeeks);

        String trimester = getTrimester(week);

        System.out.println("\n___________________________________");
        System.out.println(" RESULT: WEEK " + week + " OF PREGNANCY");
        System.out.println(" TRIMESTER: " + trimester);
        System.out.println("ESTIMATED DUE DATE (FPP): " + dueDate);
    }

    private String getTrimester(int week) {
        if (week <= 12) {
            return "1st Trimester";
        } else if (week <= 27) {
            return "2nd Trimester";
        } else {
            return "3rd Trimester";
        }
    }
}