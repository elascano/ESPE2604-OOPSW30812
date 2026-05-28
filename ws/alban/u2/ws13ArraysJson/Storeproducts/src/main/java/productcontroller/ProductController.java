/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productcontroller;

/**
 *
 * @author Kevin Alban , MKA-Programming, @ESPE
 */
import ec.edu.espe.product.view.ProductView;
import ec.edu.espe.products.model.Product;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProductController {
    private final ArrayList<Product> inventory;
    private final ProductView view;
    private final double TAX_RATE = 0.15; // 15% Tax

    public ProductController(ProductView view) {
        this.inventory = new ArrayList<>();
        this.view = view;
    }

    public void addProduct(String name, double price, int quantity) {
        Product product = new Product(name, price, quantity);
        inventory.add(product);
    }

    public void processSale() {
        double subtotal = 0;
        
        for (Product p : inventory) {
            subtotal += p.getSubtotal();
        }

        double tax = subtotal * TAX_RATE;
        double total = subtotal + tax;

        // Display results in console via View
        view.printInvoice(inventory, subtotal, tax, total);

        // Export data to JSON file
        saveToJsonFile(subtotal, tax, total);
    }

    private void saveToJsonFile(double subtotal, double tax, double total) {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("  \"products\": [\n");

        for (int i = 0; i < inventory.size(); i++) {
            json.append("    ").append(inventory.get(i).toJsonString());
            if (i < inventory.size() - 1) {
                json.append(",\n");
            } else {
                json.append("\n");
            }
        }

        json.append("  ],\n");
        json.append(String.format("  \"net_subtotal\": %.2f,\n", subtotal));
        json.append(String.format("  \"tax\": %.2f,\n", tax));
        json.append(String.format("  \"total_due\": %.2f\n", total));
        json.append("}");

        // Writing file to disk
        try (FileWriter file = new FileWriter("store_summary.json")) {
            file.write(json.toString());
            view.showMessage("Data successfully saved to 'store_summary.json'!");
        } catch (IOException e) {
            view.showMessage("Error saving JSON file: " + e.getMessage());
        }
    }
}