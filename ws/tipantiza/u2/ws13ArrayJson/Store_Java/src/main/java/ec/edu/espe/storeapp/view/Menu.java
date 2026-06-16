
/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
package ec.edu.espe.storeapp.view;

import ec.edu.espe.storeapp.model.CartItem;
import ec.edu.espe.storeapp.model.DataRepository;
import ec.edu.espe.storeapp.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final DataRepository repository;
    private final List<CartItem> shoppingCart;
    private final Scanner scanner;

    public Menu(DataRepository repository) {
        this.repository = repository;
        this.shoppingCart = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            printOptions();
            String option = scanner.nextLine().trim();
            switch (option) {
                case "1" -> displayProducts();
                case "2" -> addNewProduct();
                case "3" -> purchaseProduct();
                case "4" -> displayInvoice();
                case "5" -> updateProduct();
                case "6" -> {
                    System.out.println("\nGoodbye!");
                    return;
                }
                default -> System.out.println("\nInvalid option. Please try again.\n");
            }
        }
    }

    private void printOptions() {
        System.out.println("======== MENU ========");
        System.out.println("1. Display products");
        System.out.println("2. Add product");
        System.out.println("3. Purchase product");
        System.out.println("4. Show invoice");
        System.out.println("5. Update product");
        System.out.println("6. Exit");
        System.out.println("======================");
        System.out.print("Select an option: ");
    }

    private void displayProducts() {
        List<Product> products = repository.loadProducts();
        System.out.println("\n==== PRODUCT LIST ====\n");
        if (products.isEmpty()) {
            System.out.println("No products available.\n");
            return;
        }
        for (Product p : products) {
            System.out.printf("ID: %d | Name: %s | Category: %s | Price: $%.2f\n", 
                    p.getId(), p.getName(), p.getCategory(), p.getPrice());
        }
        System.out.println();
    }

    private void addNewProduct() {
        try {
            System.out.print("Enter product name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Enter product category: ");
            String category = scanner.nextLine().trim();
            System.out.print("Enter product price: ");
            double price = Double.parseDouble(scanner.nextLine());

            if (name.isEmpty() || category.isEmpty() || price < 0) {
                System.out.println("\nInvalid inputs. Product not added.\n");
                return;
            }

            List<Product> products = repository.loadProducts();
            int nextId = products.size() + 1;
            
            products.add(new Product(nextId, name, category, price));
            repository.saveProducts(products);
            System.out.println("\nProduct successfully added!\n");
        } catch (NumberFormatException e) {
            System.out.println("\nError: Invalid price format.\n");
        }
    }

    private void purchaseProduct() {
        displayProducts();
        List<Product> products = repository.loadProducts();
        if (products.isEmpty()) return;

        try {
            System.out.print("Enter product ID to purchase: ");
            int productId = Integer.parseInt(scanner.nextLine());
            
            Product selected = products.stream()
                    .filter(p -> p.getId() == productId)
                    .findFirst()
                    .orElse(null);

            if (selected == null) {
                System.out.println("\nProduct not found.\n");
                return;
            }

            System.out.print("Enter quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            if (quantity <= 0) {
                System.out.println("\nQuantity must be greater than 0.\n");
                return;
            }

            double subtotal = selected.calculateSubtotal(quantity);
            double tax = selected.calculateTax(subtotal);
            double total = selected.calculateTotal(subtotal, tax);

            shoppingCart.add(new CartItem(selected.getName(), selected.getCategory(), quantity, subtotal, tax, total));
            System.out.println("\nProduct successfully added to cart!\n");
        } catch (NumberFormatException e) {
            System.out.println("\nError: Invalid ID or Quantity entered.\n");
        }
    }

    private void displayInvoice() {
        System.out.println("\n==== INVOICE ====\n");
        if (shoppingCart.isEmpty()) {
            System.out.println("Your shopping cart is empty.");
            System.out.println("=========================\n");
            return;
        }

        double totalSubtotal = 0.0;
        double totalTax = 0.0;
        double totalAmount = 0.0;

        for (CartItem item : shoppingCart) {
            System.out.printf("Product: %s (Qty: %d)\n", item.getProductName(), item.getQuantity());
            System.out.printf("Subtotal: $%.2f | Tax: $%.2f | Total: $%.2f\n\n", 
                    item.getSubtotal(), item.getTax(), item.getTotal());
            
            totalSubtotal += item.getSubtotal();
            totalTax += item.getTax();
            totalAmount += item.getTotal();
        }

        System.out.println("=========================");
        System.out.printf("Subtotal: $%.2f\n", totalSubtotal);
        System.out.printf("Tax (12%%): $%.2f\n", totalTax);
        System.out.printf("Total Amount: $%.2f\n", totalAmount);
        System.out.println("=========================\n");
    }

    private void updateProduct() {
        displayProducts();
        List<Product> products = repository.loadProducts();
        if (products.isEmpty()) return;

        try {
            System.out.print("Enter product ID to update: ");
            int productId = Integer.parseInt(scanner.nextLine());
            
            Product target = products.stream()
                    .filter(p -> p.getId() == productId)
                    .findFirst()
                    .orElse(null);

            if (target == null) {
                System.out.println("\nProduct not found.\n");
                return;
            }

            System.out.print("Enter new name (leave empty to skip): ");
            String newName = scanner.nextLine().trim();
            System.out.print("Enter new category (leave empty to skip): ");
            String newCategory = scanner.nextLine().trim();
            System.out.print("Enter new price (or negative to skip): ");
            double newPrice = Double.parseDouble(scanner.nextLine());

            if (!newName.isEmpty()) target.setName(newName);
            if (!newCategory.isEmpty()) target.setCategory(newCategory);
            if (newPrice >= 0) target.setPrice(newPrice);

            repository.saveProducts(products);
            System.out.println("\nProduct updated successfully!\n");
        } catch (NumberFormatException e) {
            System.out.println("\nError: Invalid input format.\n");
        }
    }
}