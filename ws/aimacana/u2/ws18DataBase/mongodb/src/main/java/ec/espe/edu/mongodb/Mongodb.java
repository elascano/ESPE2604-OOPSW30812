package ec.espe.edu.mongodb;

import com.mongodb.client.MongoDatabase;
import ec.espe.edu.mongodb.controller.IDatabaseController;
import ec.espe.edu.mongodb.controller.IngredientController;
import ec.espe.edu.mongodb.controller.ProductController;
import ec.espe.edu.mongodb.model.Ingredient;
import ec.espe.edu.mongodb.model.Product;
import ec.espe.edu.mongodb.utils.MongoDBConnection;
import ec.espe.edu.mongodb.view.MongodbView;

/**
 * Main application entrypoint.
 * 
 * @author Anthony Aimacaña, MKA programmer, @ESPE
 */
public class Mongodb {

    public static void main(String[] args) {
        try {
            MongoDatabase database = MongoDBConnection.getDatabase();

            IDatabaseController<Ingredient> ingredientController = new IngredientController(database);
            IDatabaseController<Product> productController = new ProductController(database);

            MongodbView view = new MongodbView(ingredientController, productController);
            view.runDemo();

        } catch (Exception e) {
            System.err.println("\n[FATAL ERROR] Application failed to start:");
            e.printStackTrace();
        } finally {
            MongoDBConnection.close();
        }
    }
}
