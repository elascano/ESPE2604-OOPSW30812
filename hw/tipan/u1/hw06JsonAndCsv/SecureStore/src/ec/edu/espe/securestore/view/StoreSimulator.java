package ec.edu.espe.securestore.view;

import ec.edu.espe.securestore.model.Product;
import ec.edu.espe.securestore.model.Sell;
import ec.edu.espe.securestore.model.Credit;
import ec.edu.espe.securestore.controller.StoreController;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;

public class StoreSimulator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== STORE SYSTEM ===");

        // PRODUCT
        System.out.print("Product Id: ");
        int pId = Integer.parseInt(sc.nextLine());

        System.out.print("Product Name: ");
        String name = sc.nextLine();

        System.out.print("Price: ");
        double price = Double.parseDouble(sc.nextLine());

        Product product = StoreController.createProduct(pId, name, price);

        // SELL
        System.out.print("Quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());

        Sell sell = StoreController.createSell(1, product, quantity);

        // CREDIT
        System.out.print("Client Name: ");
        String client = sc.nextLine();

        System.out.print("Amount: ");
        double amount = Double.parseDouble(sc.nextLine());

        Credit credit = StoreController.createCredit(client, amount);

        // OUTPUT
        System.out.println("\n--- STORE DATA ---");
        System.out.println(product);
        System.out.println(sell);
        System.out.println(credit);

        // SAVE JSON
        try {

            PrintWriter jsonWriter = new PrintWriter("product.json");

            jsonWriter.println("[");

            jsonWriter.println("{\"id\":1,\"name\":\"Toilet Paper\",\"price\":1.50},");
            jsonWriter.println("{\"id\":2,\"name\":\"Plastic Cups\",\"price\":0.50},");
            jsonWriter.println("{\"id\":3,\"name\":\"Plastic Spoons\",\"price\":0.25},");
            jsonWriter.println("{\"id\":4,\"name\":\"Plastic Bags\",\"price\":0.10},");
            jsonWriter.println("{\"id\":5,\"name\":\"Disposable Plates\",\"price\":0.75},");
            jsonWriter.println("{\"id\":6,\"name\":\"Napkins\",\"price\":0.40}");

            jsonWriter.println("]");

            jsonWriter.close();

            System.out.println("\nJSON file created successfully!");

        } catch (IOException e) {

            System.out.println("Error creating JSON file");
        }

        // SAVE CSV
        try {

            PrintWriter csvWriter = new PrintWriter("sell.csv");

            csvWriter.println("sell_id,product,quantity,total");

            csvWriter.println("1,Toilet Paper,10,15.0");
            csvWriter.println("2,Plastic Cups,25,12.5");
            csvWriter.println("3,Plastic Spoons,50,8.0");
            csvWriter.println("4,Plastic Bags,30,6.5");
            csvWriter.println("5,Disposable Plates,20,14.0");
            csvWriter.println("6,Napkins,40,5.5");

            csvWriter.close();

            System.out.println("CSV file created successfully!");

        } catch (IOException e) {

            System.out.println("Error creating CSV file");
        }
    }
}