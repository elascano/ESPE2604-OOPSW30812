package ec.edu.espe.mothersapp.view;

import ec.edu.espe.mothersapp.model.Baby;
import ec.edu.espe.mothersapp.model.Mother;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Angie Nacato, Error 404, @ESPE
 */
public class MothersApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("");
            System.out.println("MATERNITY HEALTH CARE SYSTEM");
            System.out.println("1. Register Mother and Baby Profiles");
            System.out.println("2. Calculate Gestation Week");
            System.out.println("3. Monitor Warning Signs");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("Mother Name: ");
                    Mother mother = new Mother(scanner.nextLine());

                    System.out.print("Baby Name: ");
                    String babyName = scanner.nextLine();
                    System.out.print("Baby ID (Cedula): ");
                    String babyId = scanner.nextLine();
                    System.out.print("Weight (g): ");
                    double weight = scanner.nextDouble();
                    System.out.print("Height (cm): ");
                    double height = scanner.nextDouble();

                    Baby baby = new Baby(babyName, babyId, weight, height);
                    mother.getBabies().add(baby);
                    
                    System.out.println("");
                    System.out.println("Profile registered successfully");
                    break;

                case 2:
                    System.out.println("Method: 1. LMP (FUM) | 2. Ultrasound (ECO)");
                    int method = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());

                    if (method == 1) {
                        long weeks = ChronoUnit.WEEKS.between(date, LocalDate.now());
                        System.out.println("Weeks by LMP: " + weeks);
                    } else {
                        System.out.print("Weeks reported in ECO: ");
                        int ecoWeeks = scanner.nextInt();
                        long weeksSinceEco = ChronoUnit.WEEKS.between(date, LocalDate.now());
                        System.out.println("Total weeks by ECO: " + (ecoWeeks + weeksSinceEco));
                    }
                    break;

                case 3:
                    System.out.println("");
                    System.out.println("--- MSP WARNING SIGNS ---");
                    System.out.println("1. Constant headache or blurry vision");
                    System.out.println("2. Vaginal bleeding or fluid loss");
                    System.out.println("3. Swelling of hands, face, or feet");
                    System.out.println("4. Baby weak cry");
                    System.out.println("5. High fever or chills");
                    break;
            }
        } while (option != 4);
        
        System.out.println("System closed");
    }
}