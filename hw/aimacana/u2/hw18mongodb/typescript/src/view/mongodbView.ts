import { IDatabaseController } from '../controller/databaseController.js';
import { Ingredient } from '../model/ingredient.js';
import { Product } from '../model/product.js';
import { ProductCategory } from '../model/productCategory.js';

export class MongoDBView {
    constructor(
        private ingredientController: IDatabaseController<Ingredient>,
        private productController: IDatabaseController<Product>
    ) {}

    public async runDemo(): Promise<void> {
        console.log("=========================================================================");
        console.log("   MONGO DB CRUD DEMONSTRATION (MVC DESIGN - TYPESCRIPT)                 ");
        console.log("=========================================================================");

        console.log("\n[VIEW] Requesting collection cleanup from controllers...");
        await this.ingredientController.cleanCollection();
        await this.productController.cleanCollection();
        console.log("[VIEW] Previous collections dropped.");

        console.log("\n=============================================================");
        console.log(" 1. OPERATION: CREATE (Via Controllers)");
        console.log("=============================================================");

        console.log("[VIEW] Creating and inserting ingredients...");
        await this.ingredientController.create(new Ingredient("ING-001", "Azucar Blanca", 10.5, "Kg", 2.0));
        await this.ingredientController.create(new Ingredient("ING-002", "Cafe en grano Bourbon", 50.0, "Kg", 10.0));
        await this.ingredientController.create(new Ingredient("ING-003", "Leche Entera", 24.0, "Lts", 6.0));
        await this.ingredientController.create(new Ingredient("ING-004", "Leche de Almendras", 12.0, "Lts", 3.0));
        await this.ingredientController.create(new Ingredient("ING-005", "Chocolate en polvo", 8.0, "Kg", 1.5));
        await this.ingredientController.create(new Ingredient("ING-006", "Jarabe de Vainilla", 5.0, "Lts", 1.0));
        await this.ingredientController.create(new Ingredient("ING-007", "Agua purificada", 100.0, "Lts", 20.0));
        console.log("[VIEW] 7 Ingredients successfully inserted.");

        console.log("\n[VIEW] Creating and inserting menu products...");
        await this.productController.create(new Product("PROD-001", "Espresso", 2.50, ProductCategory.HOT_BEVERAGE));
        await this.productController.create(new Product("PROD-002", "Americano", 2.80, ProductCategory.HOT_BEVERAGE));
        await this.productController.create(new Product("PROD-003", "Capuccino", 3.50, ProductCategory.HOT_BEVERAGE));
        await this.productController.create(new Product("PROD-004", "Iced Latte de Almendras", 4.20, ProductCategory.COLD_BEVERAGE));
        await this.productController.create(new Product("PROD-005", "Mocaccino", 3.90, ProductCategory.HOT_BEVERAGE));
        await this.productController.create(new Product("PROD-006", "Torta de Tres Leches", 4.50, ProductCategory.DESSERT));
        await this.productController.create(new Product("PROD-007", "Croissant de Mantequilla", 2.25, ProductCategory.SNACK));
        await this.productController.create(new Product("PROD-008", "Muffin de Arandanos", 2.50, ProductCategory.DESSERT));
        console.log("[VIEW] 8 Products successfully inserted.");

        console.log("\n=============================================================");
        console.log(" 2. OPERATION: READ (Retrieve & Display Information)");
        console.log("=============================================================");
        await this.displayAllData();

        console.log("\n=============================================================");
        console.log(" 3. OPERATION: UPDATE (Modify Existing State)");
        console.log("=============================================================");

        console.log("[VIEW] Requesting stock increase for Bourbon Coffee (ING-002)...");
        const beforeCoffee = await this.ingredientController.readById("ingredientId", "ING-002");
        console.log(`   * Before: ${beforeCoffee?.name} -> Stock: ${beforeCoffee?.stockQuantity}`);

        await this.ingredientController.update("ingredientId", "ING-002", "stockQuantity", 65.0);

        const afterCoffee = await this.ingredientController.readById("ingredientId", "ING-002");
        console.log(`   * After: ${afterCoffee?.name} -> Stock: ${afterCoffee?.stockQuantity}`);

        console.log("\n[VIEW] Requesting price update for Espresso (PROD-001)...");
        const beforeEspresso = await this.productController.readById("productId", "PROD-001");
        console.log(`   * Before: ${beforeEspresso?.name} -> Price: $${beforeEspresso?.price}`);

        await this.productController.update("productId", "PROD-001", "price", 2.95);

        const afterEspresso = await this.productController.readById("productId", "PROD-001");
        console.log(`   * After: ${afterEspresso?.name} -> Price: $${afterEspresso?.price}`);

        console.log("\n=============================================================");
        console.log(" 4. OPERATION: DELETE (Targeted Record Removal)");
        console.log("=============================================================");

        console.log("[VIEW] Requesting deletion of 'Azucar Blanca' (ING-001)...");
        await this.ingredientController.delete("ingredientId", "ING-001");
        console.log("[VIEW] Ingredient ING-001 deleted.");

        console.log("\n[VIEW] Requesting deletion of 'Muffin de Arandanos' (PROD-008)...");
        await this.productController.delete("productId", "PROD-008");
        console.log("[VIEW] Product PROD-008 deleted.");

        console.log("\n=============================================================");
        console.log("   FINAL DATABASE STATE (PERSISTED IN MONGODB)               ");
        console.log("=============================================================");
        await this.displayAllData();

        console.log("\n[VIEW] Demonstration finished. Data remains persisted in MongoDB.");
    }

    private async displayAllData(): Promise<void> {
        const ingredients = await this.ingredientController.readAll();
        console.log(`Active Ingredients List (${ingredients.length}):`);
        for (const ing of ingredients) {
            console.log(` -> Ingredient{ingredientId='${ing.ingredientId}', name='${ing.name}', stockQuantity=${ing.stockQuantity}, unit='${ing.unit}', minimumAlertQuantity=${ing.minimumAlertQuantity}}`);
        }

        const products = await this.productController.readAll();
        console.log(`\nActive Products List (${products.length}):`);
        for (const p of products) {
            console.log(` -> Product{productId='${p.productId}', name='${p.name}', price=${p.price}, category=${p.category}}`);
        }
    }
}
