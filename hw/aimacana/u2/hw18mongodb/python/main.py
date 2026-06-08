import sys
from pathlib import Path

# Add the project root to sys.path so modules can import from model/controller/database/view correctly
root_dir = str(Path(__file__).resolve().parent)
if root_dir not in sys.path:
    sys.path.append(root_dir)

from database.connection import MongoDBConnection
from controller.ingredient_controller import IngredientController
from controller.product_controller import ProductController
from view.mongodb_view import MongoDBView

def main():
    try:
        db = MongoDBConnection.get_database()
        
        ingredient_controller = IngredientController(db)
        product_controller = ProductController(db)
        
        view = MongoDBView(ingredient_controller, product_controller)
        view.run_demo()
        
    except Exception as e:
        print(f"\n[FATAL ERROR] Application failed to start: {e}", file=sys.stderr)
    finally:
        MongoDBConnection.close()

if __name__ == "__main__":
    main()
