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
public class CommunityActivity {

    public void showEducationalResources() {

        Scanner sc = new Scanner(System.in);

        int option;

        do {

            System.out.println("\n____ EDUCATIONAL RESOURCES ____ ");
            System.out.println("1. Baby does not sleep");
            System.out.println("2. Baby does not latch during breastfeeding");
            System.out.println("3. How to help the baby burp");
            System.out.println("4. Baby crying constantly");
            System.out.println("5. Exit");

            System.out.print("Select an option: ");
            option = sc.nextInt();

            switch (option) {

                case 1:

                    System.out.println("\n____ TIP 1 ____ ");
                    System.out.println("Keep the room quiet and dark.");

                    System.out.println("\n____  TIP 2____ ");
                    System.out.println("Rock the baby gently.");

                    System.out.println("\n____  TIP 3 ____ ");
                    System.out.println("Avoid loud noises before bedtime.");

                    break;

                case 2:

                    System.out.println("\n____ TIP 1 ____ ");
                    System.out.println("Check the baby's position.");

                    System.out.println("\n____  TIP 2 ____ ");
                    System.out.println("Make sure the baby's mouth covers the nipple correctly.");

                    System.out.println("\n____  TIP 3 ____ ");
                    System.out.println("Stay calm and try different breastfeeding positions.");

                    break;

                case 3:

                    System.out.println("\n____ TIP 1 ____ ");
                    System.out.println("Place the baby on your shoulder.");

                    System.out.println("\n____ TIP 2 ____ ");
                    System.out.println("Pat the baby's back softly.");

                    System.out.println("\n____  TIP 3 ____ ");
                    System.out.println("Keep the baby upright after feeding.");

                    break;

                case 4:

                    System.out.println("\n____  TIP 1 ____ ");
                    System.out.println("Check if the baby is hungry or uncomfortable.");

                    System.out.println("\n____  TIP 2 ____ ");
                    System.out.println("Verify diaper condition.");

                    System.out.println("\n____  TIP 3____ ");
                    System.out.println("Try calming sounds or gentle rocking.");

                    break;

                case 5:

                    System.out.println("Leaving educational resources...");
                    break;

                default:

                    System.out.println("Invalid option.");
            }

        } while (option != 5);
    }
}
