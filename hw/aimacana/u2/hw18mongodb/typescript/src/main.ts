import { MongoDBConnection } from './database/connection.js';
import { IngredientController } from './controller/ingredientController.js';
import { ProductController } from './controller/productController.js';
import { MongoDBView } from './view/mongodbView.js';

async function main() {
    try {
        const db = await MongoDBConnection.getDatabase();

        const ingredientController = new IngredientController(db);
        const productController = new ProductController(db);

        const view = new MongoDBView(ingredientController, productController);
        await view.runDemo();

    } catch (error) {
        console.error('\n[FATAL ERROR] Application failed to start:', error);
    } finally {
        await MongoDBConnection.close();
    }
}

main();
