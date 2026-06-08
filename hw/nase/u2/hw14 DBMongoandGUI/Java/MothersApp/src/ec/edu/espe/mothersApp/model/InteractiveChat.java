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

public class InteractiveChat {

    public void startChat() {

        Scanner sc = new Scanner(System.in);

        String message;

        System.out.println("\n____  COMMUNITY CHAT FOR MOTHERS____ ");
        System.out.println("Type 'exit' to close the chat.\n");

        while (true) {

            System.out.print("Mother: ");
            message = sc.nextLine();

            if (message.equalsIgnoreCase("exit")) {

                System.out.println("Closing chat...");
                break;
            }

            if (message.toLowerCase().contains("fever")) {

                System.out.println("System: Please monitor the baby's temperature carefully.");

            } else if (message.toLowerCase().contains("feeding")) {

                System.out.println("System: Feeding difficulties may require medical attention.");

            } else if (message.toLowerCase().contains("crying")) {

                System.out.println("System: Persistent crying can indicate discomfort or illness.");

            } else {

                System.out.println("System: Your question has been received by the community.");
            }
        }
    }
}