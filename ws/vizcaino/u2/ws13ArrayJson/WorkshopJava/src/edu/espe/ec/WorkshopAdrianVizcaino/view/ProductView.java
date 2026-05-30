/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.espe.ec.WorkshopAdrianVizcaino.view;

/**
 *
 * @author Adrian Vizcaino <The-Softwarrios at ESPE>
 */
import edu.espe.ec.WorkshopAdrianVizcaino.model.Product;
import edu.espe.ec.WorkshopAdrianVizcaino.model.ProductModel;

import java.util.Scanner;

public class ProductView {

    Scanner sc = new Scanner(System.in);

    ProductModel model = new ProductModel();

    public void menu() {

        int option;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. Show Products");
            System.out.println("3. Total Quantity");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");

            System.out.print("Option: ");
            option = sc.nextInt();

            switch(option) {

                case 1:

                    addProduct();
                    break;

                case 2:

                    showProducts();
                    break;

                case 3:

                    System.out.println(
                            "Total Products: " +
                            model.totalProducts());

                    break;

                case 4:

                    deleteProduct();
                    break;

                case 5:

                    System.out.println("Goodbye");
                    break;

                default:

                    System.out.println("Invalid option");
            }

        } while(option != 5);
    }

    public void addProduct() {

        String option;

        do {

            System.out.print("ID: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            Product p =
                    new Product(id, name, quantity);

            model.addProduct(p);

            System.out.println("Product added");

            sc.nextLine();

            System.out.print(
                    "Do you want to continue? (yes/no): ");

            option = sc.nextLine();

        } while(option.equalsIgnoreCase("yes"));
    }

    public void showProducts() {

        for (Product p : model.getProducts()) {

            System.out.println(p);
        }
    }

    public void deleteProduct() {

        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        model.deleteProduct(id);
    }
}