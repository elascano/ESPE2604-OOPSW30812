/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.products.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.products.model.*;
import org.bson.Document;
import ec.edu.espe.products.utils.MongoConnection;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class ProductController {

    private MongoConnection connection;

    public ProductController() {
        connection = new MongoConnection();
    }

    public void create(Product product) {

        MongoDatabase database = connection.getDatabase();
        MongoCollection<Document> collection = database.getCollection("products");
        Document document = new Document();

        document.append("id", product.getId());
        document.append("name", product.getName());
        document.append("price", product.getPrice());

        if (product instanceof Book book) {
            document.append("type", "Book");
            document.append("author", book.getAuthor());
            document.append("pages", book.getPages());

        } else if (product instanceof Watch watch) {
            document.append("type", "Watch");
            document.append("strapMaterial", watch.getStrapMaterial());

            Document battery = new Document();
            battery.append("capacity", watch.getBattery().getCapacity());
            battery.append("rechargeable", watch.getBattery().isRechargeable());

            document.append("battery", battery);
        }

        collection.insertOne(document);
        System.out.println("Product saved.");

    }

    public void read() {

        MongoDatabase database = connection.getDatabase();

        MongoCollection<Document> collection = database.getCollection("products");

        for (Document document : collection.find()) {
            System.out.println(document.toJson());
        }
    }

    public void delete(int id) {

        MongoDatabase database = connection.getDatabase();
        MongoCollection<Document> collection = database.getCollection("products");

        collection.deleteOne(new Document("id", id));
    }

    public void update(Product product) {

        MongoDatabase database = connection.getDatabase();
        MongoCollection<Document> collection = database.getCollection("products");
        Document document = new Document();

        document.append("name", product.getName());
        document.append("price", product.getPrice());

        collection.updateOne(
                new Document("id", product.getId()),
                new Document("$set", document)
        );

    }

    public void sell(Product product) {
        product.sell();
    }
}
