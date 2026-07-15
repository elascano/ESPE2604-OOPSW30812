/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.abstractfactory;

import java.util.Scanner;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class ClientApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GUIFactory factory = null;

        System.out.println("SELECT OPERATING SYSTEM");
        System.out.println("1. Windows");
        System.out.println("2. Linux");
        System.out.println("3. MacOS");
        System.out.print("Option: ");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                factory = new WinFactory();
                break;

            case 2:
                factory = new LinuxFactory();
                break;

            case 3:
                factory = new MacFactory();
                break;

            default:
                System.out.println("Invalid option.");
                System.exit(0);
        }

        Button button = factory.createButton();
        Menu menu = factory.createMenu();

        System.out.println("\nCreated components:");
        button.setCaption("Play");
        menu.setCaption("File");

        button.paint();
        menu.paint();

        scanner.close();
    }
}