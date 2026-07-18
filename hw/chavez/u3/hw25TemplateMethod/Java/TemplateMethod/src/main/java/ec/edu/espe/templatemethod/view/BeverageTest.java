/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.templatemethod.view;

import ec.edu.espe.templatemethod.model.*;
import java.util.Scanner;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class BeverageTest {
 
    
    public static void main(String[] args) {
        int opcion;
        try (Scanner scanner = new Scanner(System.in)) {
            CaffeineBeverage tea = new Tea();
            CaffeineBeverage coffee = new Coffee();
            do {
                System.out.println("--- Beverage Menu ---");
                System.out.println("1. Make Tea");
                System.out.println("2. Make Coffee");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                
                opcion = scanner.nextInt();
                
                switch (opcion) {
                    case 1 -> {
                        System.out.println("\nMaking tea ...");
                        tea.prepareRecipe();
                    }
                    case 2 -> {
                        System.out.println("\nMaking coffee ...");
                        coffee.prepareRecipe();
                    }
                    case 3 -> System.out.println("Exiting the program...");
                    default -> System.out.println("Invalid option. Try again.");
                }
                System.out.println(); 
            } while (opcion != 3); 
        }
    }
    
}

