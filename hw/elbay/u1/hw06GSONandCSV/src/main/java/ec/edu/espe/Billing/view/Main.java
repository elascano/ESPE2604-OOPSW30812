package ec.edu.espe.Billing.view;

import ec.edu.espe.Billing.model.Product;
import ec.edu.espe.Billing.model.Invoice; 
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Product> inventory = new ArrayList<>();
        
        int option;
        int i;
        boolean isFound;
        
        String idInput;
        String nameInput;
        double priceInput;
        int stockInput;
        
        String customerName;
        String idToDelete;
        int invoiceNumber = 1; 
        int selection;
        double calculatedSubtotal;
        double totalVat;
        
        Product auxProduct;
        Invoice myInvoice;

        do {
            System.out.println("\n--- CODE_BROS MENU ---");
            System.out.println("1. Register Product");
            System.out.println("2. Generate Invoice");
            System.out.println("3. Delete Product");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            
            option = input.nextInt();
            input.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("ID: ");
                    idInput = input.nextLine();
                    System.out.print("Name: ");
                    nameInput = input.nextLine();
                    System.out.print("Price: ");
                    priceInput = input.nextDouble();
                    System.out.print("Stock: ");
                    stockInput = input.nextInt();
                    
                    inventory.add(new Product(idInput, nameInput, priceInput, stockInput));
                    System.out.println("Product saved.");
                    break;

                case 2:
                    if (inventory.isEmpty()) {
                        System.out.println("Inventory is empty.");
                    } else {
                        System.out.print("Customer Name: ");
                        customerName = input.nextLine();
                        
                        System.out.println("\nPRODUCT LIST:");
                        for (i = 0; i < inventory.size(); i++) {
                            System.out.println((i + 1) + ". " + inventory.get(i).getName());
                        }
                        
                        System.out.print("Choose product number: ");
                        selection = input.nextInt() - 1;

                        if (selection >= 0 && selection < inventory.size()) {
                            auxProduct = inventory.get(selection);
                            
                            calculatedSubtotal = auxProduct.getUnitPrice();
                            totalVat = calculatedSubtotal * 1.15;

                            myInvoice = new Invoice(invoiceNumber, "07/05/2026", "Didier Elbay", customerName, totalVat, calculatedSubtotal);

                            System.out.println("\n========================================");
                            System.out.println("            GENERATED INVOICE           "); 
                            System.out.println("========================================");
                            System.out.println("Invoice N: " + myInvoice.getIncoiceNumber());
                            System.out.println("Date:      " + myInvoice.getDate());
                            System.out.println("Cashier:   " + myInvoice.getCashier());
                            System.out.println("Customer:  " + myInvoice.getCustomer());
                            System.out.println("----------------------------------------");
                            System.out.println("Detail:    " + auxProduct.getName());
                            System.out.println("Subtotal:  $" + myInvoice.getSubtotal());
                            System.out.println("TOTAL:     $" + myInvoice.getTotal());
                            System.out.println("========================================\n");
                            
                            invoiceNumber++; 
                        }
                    }
                    break;

                case 3:
                    System.out.print("ID to delete: ");
                    idToDelete = input.nextLine();      
                    isFound = false;

                    for (i = 0; i < inventory.size(); i++) {
                        if (inventory.get(i).getId().equals(idToDelete)) {
                            inventory.remove(i);
                            isFound = true;
                            System.out.println("Deleted.");
                            break;
                        }
                    }
                    if (!isFound) System.out.println("Product not found.");
                    break;

                case 4:
                    System.out.println("Goodbye.");
                    break;
            }
        } while (option != 4);
    }
}