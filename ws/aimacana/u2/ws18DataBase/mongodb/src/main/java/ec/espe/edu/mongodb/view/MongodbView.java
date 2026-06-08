package ec.espe.edu.mongodb.view;

import ec.espe.edu.mongodb.controller.IDatabaseController;
import ec.espe.edu.mongodb.model.Ingredient;
import ec.espe.edu.mongodb.model.Product;
import ec.espe.edu.mongodb.model.ProductCategory;

import java.math.BigDecimal;
import java.util.List;

/**
 * View presentation layer for the MongoDB CRUD demonstration.
 * 
 * @author Anthony Aimacaña, MKA programmer, @ESPE
 */
public class MongodbView {
    private final IDatabaseController<Ingredient> ingredientController;
    private final IDatabaseController<Product> productController;

    public MongodbView(IDatabaseController<Ingredient> ingredientController, IDatabaseController<Product> productController) {
        this.ingredientController = ingredientController;
        this.productController = productController;
    }

    public void runDemo() {
        System.out.println("=========================================================================");
        System.out.println("   MONGO DB CRUD DEMONSTRATION (MVC DESIGN)                              ");
        System.out.println("=========================================================================");

        System.out.println("\n[VIEW] Requesting collection cleanup from controllers...");
        ingredientController.cleanCollection();
        productController.cleanCollection();
        System.out.println("[VIEW] Previous collections dropped.");

        System.out.println("\n=============================================================");
        System.out.println(" 1. OPERATION: CREATE (Via Controllers)");
        System.out.println("=============================================================");
        
        System.out.println("[VIEW] Creating and inserting ingredients...");
        ingredientController.create(new Ingredient("ING-001", "Azucar Blanca", new BigDecimal("10.5"), "Kg", new BigDecimal("2.0")));
        ingredientController.create(new Ingredient("ING-002", "Cafe en grano Bourbon", new BigDecimal("50.0"), "Kg", new BigDecimal("10.0")));
        ingredientController.create(new Ingredient("ING-003", "Leche Entera", new BigDecimal("24.0"), "Lts", new BigDecimal("6.0")));
        ingredientController.create(new Ingredient("ING-004", "Leche de Almendras", new BigDecimal("12.0"), "Lts", new BigDecimal("3.0")));
        ingredientController.create(new Ingredient("ING-005", "Chocolate en polvo", new BigDecimal("8.0"), "Kg", new BigDecimal("1.5")));
        ingredientController.create(new Ingredient("ING-006", "Jarabe de Vainilla", new BigDecimal("5.0"), "Lts", new BigDecimal("1.0")));
        ingredientController.create(new Ingredient("ING-007", "Agua purificada", new BigDecimal("100.0"), "Lts", new BigDecimal("20.0")));
        System.out.println("[VIEW] 7 Ingredients successfully inserted.");

        System.out.println("\n[VIEW] Creating and inserting menu products...");
        productController.create(new Product("PROD-001", "Espresso", new BigDecimal("2.50"), ProductCategory.HOT_BEVERAGE));
        productController.create(new Product("PROD-002", "Americano", new BigDecimal("2.80"), ProductCategory.HOT_BEVERAGE));
        productController.create(new Product("PROD-003", "Capuccino", new BigDecimal("3.50"), ProductCategory.HOT_BEVERAGE));
        productController.create(new Product("PROD-004", "Iced Latte de Almendras", new BigDecimal("4.20"), ProductCategory.COLD_BEVERAGE));
        productController.create(new Product("PROD-005", "Mocaccino", new BigDecimal("3.90"), ProductCategory.HOT_BEVERAGE));
        productController.create(new Product("PROD-006", "Torta de Tres Leches", new BigDecimal("4.50"), ProductCategory.DESSERT));
        productController.create(new Product("PROD-007", "Croissant de Mantequilla", new BigDecimal("2.25"), ProductCategory.SNACK));
        productController.create(new Product("PROD-008", "Muffin de Arandanos", new BigDecimal("2.50"), ProductCategory.DESSERT));
        System.out.println("[VIEW] 8 Products successfully inserted.");

        System.out.println("\n=============================================================");
        System.out.println(" 2. OPERATION: READ (Retrieve & Display Information)");
        System.out.println("=============================================================");
        
        displayAllData();

        System.out.println("\n=============================================================");
        System.out.println(" 3. OPERATION: UPDATE (Modify Existing State)");
        System.out.println("=============================================================");

        System.out.println("[VIEW] Requesting stock increase for Bourbon Coffee (ING-002)...");
        Ingredient beforeCoffee = ingredientController.readById("ingredientId", "ING-002");
        System.out.println("   * Before: " + beforeCoffee.getName() + " -> Stock: " + beforeCoffee.getStockQuantity());
        
        ingredientController.update("ingredientId", "ING-002", "stockQuantity", new BigDecimal("65.0"));
        
        Ingredient afterCoffee = ingredientController.readById("ingredientId", "ING-002");
        System.out.println("   * After: " + afterCoffee.getName() + " -> Stock: " + afterCoffee.getStockQuantity());

        System.out.println("\n[VIEW] Requesting price update for Espresso (PROD-001)...");
        Product beforeEspresso = productController.readById("productId", "PROD-001");
        System.out.println("   * Before: " + beforeEspresso.getName() + " -> Price: $" + beforeEspresso.getPrice());
        
        productController.update("productId", "PROD-001", "price", new BigDecimal("2.95"));
        
        Product afterEspresso = productController.readById("productId", "PROD-001");
        System.out.println("   * After: " + afterEspresso.getName() + " -> Price: $" + afterEspresso.getPrice());

        System.out.println("\n=============================================================");
        System.out.println(" 4. OPERATION: DELETE (Targeted Record Removal)");
        System.out.println("=============================================================");

        System.out.println("[VIEW] Requesting deletion of 'Azucar Blanca' (ING-001)...");
        ingredientController.delete("ingredientId", "ING-001");
        System.out.println("[VIEW] Ingredient ING-001 deleted.");

        System.out.println("\n[VIEW] Requesting deletion of 'Muffin de Arandanos' (PROD-008)...");
        productController.delete("productId", "PROD-008");
        System.out.println("[VIEW] Product PROD-008 deleted.");

        System.out.println("\n=============================================================");
        System.out.println("   FINAL DATABASE STATE (PERSISTED IN MONGODB)               ");
        System.out.println("=============================================================");
        
        displayAllData();
        
        System.out.println("\n[VIEW] Demonstration finished. Data remains persisted in MongoDB.");
    }

    private void displayAllData() {
        List<Ingredient> ingredients = ingredientController.readAll();
        System.out.println("Active Ingredients List (" + ingredients.size() + "):");
        for (Ingredient ing : ingredients) {
            System.out.println(" -> " + ing);
        }

        List<Product> products = productController.readAll();
        System.out.println("\nActive Products List (" + products.size() + "):");
        for (Product p : products) {
            System.out.println(" -> " + p);
        }
    }
}
