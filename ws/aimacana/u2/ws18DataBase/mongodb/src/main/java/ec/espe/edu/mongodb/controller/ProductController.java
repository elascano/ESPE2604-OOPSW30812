package ec.espe.edu.mongodb.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import ec.espe.edu.mongodb.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller implementation for Product database operations.
 * 
 * @author Anthony Aimacaña, MKA programmer, @ESPE
 */
public class ProductController implements IDatabaseController<Product> {
    private final MongoCollection<Product> collection;

    /**
     * Constructor using Dependency Injection (DIP) to receive the database reference.
     * 
     * @param database the MongoDB database instance
     */
    public ProductController(MongoDatabase database) {
        this.collection = database.getCollection("products", Product.class);
    }

    @Override
    public void create(Product entity) {
        if (entity != null) {
            collection.insertOne(entity);
        }
    }

    @Override
    public List<Product> readAll() {
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public Product readById(String idField, String idValue) {
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
