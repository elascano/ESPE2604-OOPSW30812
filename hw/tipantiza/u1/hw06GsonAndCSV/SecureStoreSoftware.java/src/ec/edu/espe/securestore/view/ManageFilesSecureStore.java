/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.securestore.view;

import ec.edu.espe.securestore.model.FileManager;
import ec.edu.espe.securestore.model.Product;
import ec.edu.espe.securestore.model.CustomerAnalytics;
import ec.edu.espe.securestore.model.SupplierManager;
import java.util.Scanner;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
public class ManageFilesSecureStore {
    
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.println("\n=== SECURE STORE MENU ===");
            System.out.println("1. Add Product");
            System.out.println("2. Add Customer Analytics");
            System.out.println("3. Add Supplier");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (option) {

                case 1:
                    System.out.println("\n--- Enter Product Data ---");

                    System.out.print("ID: ");
                    int pId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Name: ");
                    String pName = scanner.nextLine();

                    System.out.print("Stock: ");
                    int pStock = scanner.nextInt();

                    System.out.print("Price: ");
                    double pPrice = scanner.nextDouble();

                    Product product = new Product(pId, pName, pStock, pPrice);

                    FileManager.saveProductCSV(product);
                    FileManager.saveProductJSON(product);

                    System.out.println("Product saved.");
                    break;

                case 2:
                    System.out.println("\n--- Enter Customer Data ---");

                    System.out.print("ID: ");
                    int cId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Customer Name: ");
                    String cName = scanner.nextLine();

                    System.out.print("Purchase Category (e.g., groceries, cleaning): ");
                    String cCategory = scanner.nextLine();

                    CustomerAnalytics customer = new CustomerAnalytics(cId, cName, cCategory);

                    FileManager.saveCustomerCSV(customer);
                    FileManager.saveCustomerJSON(customer);

                    System.out.println("Customer data saved.");
                    break;

                case 3:
                    System.out.println("\n--- Enter Supplier Data ---");

                    System.out.print("ID: ");
                    int sId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Supplier Name: ");
                    String sName = scanner.nextLine();

                    System.out.print("Email: ");
                    String sEmail = scanner.nextLine();

                    SupplierManager supplier = new SupplierManager(sId, sName, sEmail);

                    FileManager.saveSupplierCSV(supplier);
                    FileManager.saveSupplierJSON(supplier);

                    System.out.println("Supplier saved.");
                    break;

                case 4:
                    running = false;
                    System.out.println("Program finished.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
    
    
}
