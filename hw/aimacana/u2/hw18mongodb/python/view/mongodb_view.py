from decimal import Decimal
from controller.database_controller import IDatabaseController
from model.ingredient import Ingredient
from model.product import Product
from model.product_category import ProductCategory

class MongoDBView:
    def __init__(self, ingredient_controller: IDatabaseController[Ingredient], product_controller: IDatabaseController[Product]):
        self.ingredient_controller = ingredient_controller
        self.product_controller = product_controller

    def run_demo(self):
        print("=========================================================================")
        print("   MONGO DB CRUD DEMONSTRATION (MVC DESIGN - PYTHON)                     ")
        print("=========================================================================")

        print("\n[VIEW] Requesting collection cleanup from controllers...")
        self.ingredient_controller.clean_collection()
        self.product_controller.clean_collection()
        print("[VIEW] Previous collections dropped.")

        print("\n=============================================================")
        print(" 1. OPERATION: CREATE (Via Controllers)")
        print("=============================================================")
        
        print("[VIEW] Creating and inserting ingredients...")
        self.ingredient_controller.create(Ingredient("ING-001", "Azucar Blanca", Decimal("10.5"), "Kg", Decimal("2.0")))
        self.ingredient_controller.create(Ingredient("ING-002", "Cafe en grano Bourbon", Decimal("50.0"), "Kg", Decimal("10.0")))
        self.ingredient_controller.create(Ingredient("ING-003", "Leche Entera", Decimal("24.0"), "Lts", Decimal("6.0")))
        self.ingredient_controller.create(Ingredient("ING-004", "Leche de Almendras", Decimal("12.0"), "Lts", Decimal("3.0")))
        self.ingredient_controller.create(Ingredient("ING-005", "Chocolate en polvo", Decimal("8.0"), "Kg", Decimal("1.5")))
        self.ingredient_controller.create(Ingredient("ING-006", "Jarabe de Vainilla", Decimal("5.0"), "Lts", Decimal("1.0")))
        self.ingredient_controller.create(Ingredient("ING-007", "Agua purificada", Decimal("100.0"), "Lts", Decimal("20.0")))
        print("[VIEW] 7 Ingredients successfully inserted.")

        print("\n[VIEW] Creating and inserting menu products...")
        self.product_controller.create(Product("PROD-001", "Espresso", Decimal("2.50"), ProductCategory.HOT_BEVERAGE))
        self.product_controller.create(Product("PROD-002", "Americano", Decimal("2.80"), ProductCategory.HOT_BEVERAGE))
        self.product_controller.create(Product("PROD-003", "Capuccino", Decimal("3.50"), ProductCategory.HOT_BEVERAGE))
        self.product_controller.create(Product("PROD-004", "Iced Latte de Almendras", Decimal("4.20"), ProductCategory.COLD_BEVERAGE))
        self.product_controller.create(Product("PROD-005", "Mocaccino", Decimal("3.90"), ProductCategory.HOT_BEVERAGE))
        self.product_controller.create(Product("PROD-006", "Torta de Tres Leches", Decimal("4.50"), ProductCategory.DESSERT))
        self.product_controller.create(Product("PROD-007", "Croissant de Mantequilla", Decimal("2.25"), ProductCategory.SNACK))
        self.product_controller.create(Product("PROD-008", "Muffin de Arandanos", Decimal("2.50"), ProductCategory.DESSERT))
        print("[VIEW] 8 Products successfully inserted.")

        print("\n=============================================================")
        print(" 2. OPERATION: READ (Retrieve & Display Information)")
        print("=============================================================")
        self._display_all_data()

        print("\n=============================================================")
        print(" 3. OPERATION: UPDATE (Modify Existing State)")
        print("=============================================================")

        print("[VIEW] Requesting stock increase for Bourbon Coffee (ING-002)...")
        before_coffee = self.ingredient_controller.read_by_id("ingredientId", "ING-002")
        print(f"   * Before: {before_coffee.name} -> Stock: {before_coffee.stock_quantity}")
        
        self.ingredient_controller.update("ingredientId", "ING-002", "stockQuantity", Decimal("65.0"))
        
        after_coffee = self.ingredient_controller.read_by_id("ingredientId", "ING-002")
        print(f"   * After: {after_coffee.name} -> Stock: {after_coffee.stock_quantity}")

        print("\n[VIEW] Requesting price update for Espresso (PROD-001)...")
        before_espresso = self.product_controller.read_by_id("productId", "PROD-001")
        print(f"   * Before: {before_espresso.name} -> Price: ${before_espresso.price}")
        
        self.product_controller.update("productId", "PROD-001", "price", Decimal("2.95"))
        
        after_espresso = self.product_controller.read_by_id("productId", "PROD-001")
        print(f"   * After: {after_espresso.name} -> Price: ${after_espresso.price}")

        print("\n=============================================================")
        print(" 4. OPERATION: DELETE (Targeted Record Removal)")
        print("=============================================================")

        print("[VIEW] Requesting deletion of 'Azucar Blanca' (ING-001)...")
        self.ingredient_controller.delete("ingredientId", "ING-001")
        print("[VIEW] Ingredient ING-001 deleted.")

        print("\n[VIEW] Requesting deletion of 'Muffin de Arandanos' (PROD-008)...")
        self.product_controller.delete("productId", "PROD-008")
        print("[VIEW] Product PROD-008 deleted.")

        print("\n=============================================================")
        print("   FINAL DATABASE STATE (PERSISTED IN MONGODB)               ")
        print("=============================================================")
        self._display_all_data()
        
        print("\n[VIEW] Demonstration finished. Data remains persisted in MongoDB.")

    def _display_all_data(self):
        ingredients = self.ingredient_controller.read_all()
        print(f"Active Ingredients List ({len(ingredients)}):")
        for ing in ingredients:
            print(f" -> {ing}")

        products = self.product_controller.read_all()
        print(f"\nActive Products List ({len(products)}):")
        for p in products:
            print(f" -> {p}")
