package ec.edu.espe.coffeeshop.view;

import ec.edu.espe.coffeeshop.model.CoffeeShop;
import ec.edu.espe.coffeeshop.model.Order;
import ec.edu.espe.coffeeshop.model.OrderItem;
import ec.edu.espe.coffeeshop.model.Product;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeShop shop = new CoffeeShop("Central Perk", "123 Main St");
        
        int option;
        do {
            System.out.println("\n--- Coffee Shop System ---");
            System.out.println("1. Create New Order");
            System.out.println("2. Show Orders");
            System.out.println("3. Save to JSON and CSV");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();
            scanner.nextLine();
            
            switch(option) {
                case 1:
                    System.out.print("Enter Order ID: ");
                    String orderId = scanner.nextLine();
                    Order order = new Order(orderId);
                    
                    String addMore = "y";
                    while(addMore.equalsIgnoreCase("y")) {
                        System.out.print("Enter Product ID: ");
                        String prodId = scanner.nextLine();
                        System.out.print("Enter Product Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Product Price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Enter Quantity: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();
                        
                        Product product = new Product(prodId, name, price);
                        OrderItem item = new OrderItem("OI-" + System.currentTimeMillis(), product, quantity);
                        order.addItem(item);
                        
                        System.out.print("Add another item to this order? (y/n): ");
                        addMore = scanner.nextLine();
                    }
                    shop.addOrder(order);
                    System.out.println("Order added successfully!");
                    break;
                    
                case 2:
                    System.out.println("\n--- Orders for " + shop.getName() + " ---");
                    if (shop.getOrders().isEmpty()) {
                        System.out.println("No orders found.");
                    } else {
                        for (Order o : shop.getOrders()) {
                            System.out.println("Order ID: " + o.getOrderId() + " | Total: $" + o.calculateTotal());
                            for (OrderItem oi : o.getItems()) {
                                System.out.println("  - " + oi.getProduct().getName() + " (x" + oi.getQuantity() + ") = $" + oi.getSubtotal());
                            }
                        }
                    }
                    break;
                    
                case 3:
                    // Save to CSV
                    try (FileWriter writer = new FileWriter("coffeeshop.csv")) {
                        writer.write("ShopName,OrderID,OrderItemID,ProductID,ProductName,Price,Quantity,Subtotal\n");
                        for (Order o : shop.getOrders()) {
                            for (OrderItem oi : o.getItems()) {
                                Product p = oi.getProduct();
                                writer.write(String.format("%s,%s,%s,%s,%s,%.2f,%d,%.2f\n",
                                        shop.getName(), o.getOrderId(), oi.getOrderItemId(),
                                        p.getProductId(), p.getName(), p.getPrice(),
                                        oi.getQuantity(), oi.getSubtotal()));
                            }
                        }
                        System.out.println("File 'coffeeshop.csv' generated successfully.");
                    } catch (IOException e) {
                        System.err.println("Error saving CSV: " + e.getMessage());
                    }
                    
                    // Save to JSON
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    try (FileWriter writer = new FileWriter("coffeeshop.json")) {
                        gson.toJson(shop, writer);
                        System.out.println("File 'coffeeshop.json' generated successfully.");
                    } catch (IOException e) {
                        System.err.println("Error saving JSON: " + e.getMessage());
                    }
                    break;
                    
                case 4:
                    System.out.println("Exiting...");
                    break;
                    
                default:
                    System.out.println("Invalid option.");
            }
        } while(option != 4);
        
        scanner.close();
    }
}
