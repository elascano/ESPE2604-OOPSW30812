package ec.espe.edu.mongodb.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import ec.espe.edu.mongodb.model.Ingredient;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller implementation for Ingredient database operations.
 * 
 * @author Anthony Aimacaña, MKA programmer, @ESPE
 */
public class IngredientController implements IDatabaseController<Ingredient> {
    private final MongoCollection<Ingredient> collection;

    /**
     * Constructor using Dependency Injection (DIP) to receive the database reference.
     * 
     * @param database the MongoDB database instance
     */
    public IngredientController(MongoDatabase database) {
        this.collection = database.getCollection("ingredients", Ingredient.class);
    }

    @Override
    public void create(Ingredient entity) {
        if (entity != null) {
            collection.insertOne(entity);
        }
    }

    @Override
    public List<Ingredient> readAll() {
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public Ingredient readById(String idField, String idValue) {
        return collection.find(Filters.eq(idField, idValue)).first();
    }

    @Override
    public void update(String idField, String idValue, String fieldName, Object newValue) {
        collection.updateOne(Filters.eq(idField, idValue), Updates.set(fieldName, newValue));
    }

    @Override
    public void delete(String idField, String idValue) {
        collection.deleteOne(Filters.eq(idField, idValue));
    }

    @Override
    public void cleanCollection() {
        collection.drop();
    }
}
