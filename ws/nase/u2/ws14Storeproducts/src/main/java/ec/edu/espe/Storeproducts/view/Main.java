/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.Storeproducts.view;

import java.util.Scanner;

import ec.edu.espe.Storeproducts.model.Product;
import ec.edu.espe.Storeproducts.model.ProductManager;
/**
 *
 * @author LABS-ESPE
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProductManager manager = new ProductManager();

        int option;

        do {

            System.out.println("\n_______ STORE MENU _______");
            System.out.println("1. Add product");
            System.out.println("2. Calculate total products");
            System.out.println("0. Exit");

            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:

                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    Product product = new Product(name, quantity);

                    manager.addProduct(product);

                    System.out.println("Product added successfully.");

                    break;

                case 2:

                    manager.showProductsTable();

                    break;

                case 0:

                    System.out.println("Program finished.");

                    break;

                default:

                    System.out.println("Invalid option.");
            }

        } while (option != 0);

        scanner.close();
    }
}
    

