/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.view;
import ec.edu.espe.controller.PhoneController;
import ec.edu.espe.controller.JsonManager;
import ec.edu.espe.model.*;
import java.util.Scanner;

/**
 *
 * @author Cristian
 */
public class Main {
     public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        PhoneController controller =
                new PhoneController();

        int option;

        do {

            System.out.println("\nPHONE SYSTEM");
            System.out.println("1. Register Phone");
            System.out.println("2. Save JSON");
            System.out.println("3. Exit");

            option = scanner.nextInt();
            scanner.nextLine();

            switch(option) {

                case 1:

                    System.out.print("Brand: ");
                    String brand =
                            scanner.nextLine();

                    System.out.print("Model: ");
                    String model =
                            scanner.nextLine();

                    System.out.print("IMEI: ");
                    String imei =
                            scanner.nextLine();

                    System.out.print("Battery mAh: ");
                    int capacity =
                            scanner.nextInt();

                    System.out.print("Screen size: ");
                    double size =
                            scanner.nextDouble();

                    scanner.nextLine();

                    System.out.print("Operator: ");
                    String operator =
                            scanner.nextLine();

                    Battery battery =
                            new Battery(capacity);

                    Screen screen =
                            new Screen(size);

                    SIMCard sim =
                            new SIMCard(operator);

                    CellPhone phone =
                            new CellPhone(
                                    brand,
                                    model,
                                    imei,
                                    battery,
                                    screen,
                                    sim
                            );

                    controller.registerPhone(phone);

                    break;

                case 2:

                    JsonManager.savePhones(
                            controller.getPhones());

                    break;

                case 3:

                    System.out.println("Goodbye!");

                    break;
            }

        } while(option != 3);
    }
    
}
