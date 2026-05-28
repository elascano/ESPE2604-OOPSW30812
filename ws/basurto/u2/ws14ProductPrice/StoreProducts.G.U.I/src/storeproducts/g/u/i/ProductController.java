package storeproducts.g.u.i;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductController {
    private final ArrayList<Product> cart;
    private final ProductView view;
    private final double TAX_RATE = 0.15; 

    public ProductController(ProductView view) {
        this.cart = new ArrayList<>();
        this.view = view;
        this.view.setListeners(new AddItemListener(), new ProcessSaleListener());
        loadInitialInventory();
    }

    private void loadInitialInventory() {
        addNewProduct("Snake Plant", 15.50, 2);
        addNewProduct("Ceramic Pot", 8.25, 3);
        addNewProduct("Organic Fertilizer", 12.00, 1);
    }

    private void addNewProduct(String name, double price, int quantity) {
        Product product = new Product(name, price, quantity);
        cart.add(product);
        view.addProductToTable(product.getName(), product.getPrice(), product.getQuantity(), product.getSubtotal());
    }

    private class AddItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String name = view.getProductName().trim();
                double price = Double.parseDouble(view.getProductPrice());
                int quantity = Integer.parseInt(view.getProductQuantity());

                if (name.isEmpty() || price <= 0 || quantity <= 0) {
                    view.displayMessage("Please enter valid positive values.");
                    return;
                }

                addNewProduct(name, price, quantity);
                view.clearInputFields();

            } catch (NumberFormatException ex) {
                view.displayMessage("Price and Quantity must be valid numbers.");
            }
        }
    }

    private class ProcessSaleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (cart.isEmpty()) {
                view.displayMessage("Your cart is empty!");
                return;
            }

            double subtotal = 0;
            for (Product p : cart) {
                subtotal += p.getSubtotal();
            }

            double tax = subtotal * TAX_RATE;
            double total = subtotal + tax;

            StringBuilder receipt = new StringBuilder();
            receipt.append("======= GARDEN STORE =======\n\n");
            for (Product p : cart) {
                receipt.append(String.format("%s (x%d)\n  Subtotal: $%.2f\n", p.getName(), p.getQuantity(), p.getSubtotal()));
            }
            receipt.append("----------------------------\n");
            receipt.append(String.format("Net Subtotal: $%.2f\n", subtotal));
            receipt.append(String.format("Tax (15%%):    $%.2f\n", tax));
            receipt.append(String.format("TOTAL DUE:   $%.2f\n", total));
            receipt.append("============================");

            view.updateReceiptDisplay(receipt.toString());
            saveToJsonFile(subtotal, tax, total);
        }
    }

    private void saveToJsonFile(double subtotal, double tax, double total) {
        StringBuilder json = new StringBuilder();
        json.append("{\n  \"products\": [\n");

        for (int i = 0; i < cart.size(); i++) {
            json.append("    ").append(cart.get(i).toJsonString());
            if (i < cart.size() - 1) json.append(",\n");
            else json.append("\n");
        }

        json.append("  ],\n");
        json.append(String.format("  \"net_subtotal\": %.2f,\n", subtotal));
        json.append(String.format("  \"tax\": %.2f,\n", tax));
        json.append(String.format("  \"total_due\": %.2f\n", total));
        json.append("}");

        try (FileWriter file = new FileWriter("store_summary.json")) {
            file.write(json.toString());
            view.displayMessage("Data successfully saved to 'store_summary.json'!");
        } catch (IOException e) {
            view.displayMessage("Error saving JSON file: " + e.getMessage());
        }
    }
}