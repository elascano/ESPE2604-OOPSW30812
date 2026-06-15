package ec.edu.espe.Billing.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ec.edu.espe.Billing.model.Payment;
import ec.edu.espe.Billing.model.Person;
import ec.edu.espe.Billing.model.Product;
import org.bson.Document;

public class BillingController {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> personCollection;
    private MongoCollection<Document> productCollection;
    private MongoCollection<Document> paymentCollection;

    public BillingController() {
        mongoClient = MongoClients.create("mongodb+srv://admin:Espe2026@christopher.i75hlaj.mongodb.net/?appName=christopher");
        database = mongoClient.getDatabase("BillingDB");
        personCollection = database.getCollection("persons");
        productCollection = database.getCollection("products");
        paymentCollection = database.getCollection("payments");
    }

    public void saveOrUpdatePerson(Person person) {
        Document doc = new Document("_id", person.getId())
                .append("name", person.getName())
                .append("email", person.getEmail());
        
        if (personCollection.find(Filters.eq("_id", person.getId())).first() != null) {
            personCollection.replaceOne(Filters.eq("_id", person.getId()), doc);
        } else {
            personCollection.insertOne(doc);
        }
    }

    public Person findPerson(String id) {
        Document doc = personCollection.find(Filters.eq("_id", id)).first();
        if (doc != null) {
            return new Person(doc.getString("_id"), doc.getString("name"), doc.getString("email"));
        }
        return null;
    }

    public void saveOrUpdateProduct(Product product) {
        Document doc = new Document("_id", product.getId())
                .append("name", product.getName())
                .append("price", product.getPrice());
        
        if (productCollection.find(Filters.eq("_id", product.getId())).first() != null) {
            productCollection.replaceOne(Filters.eq("_id", product.getId()), doc);
        } else {
            productCollection.insertOne(doc);
        }
    }

    public Product findProduct(String id) {
        Document doc = productCollection.find(Filters.eq("_id", id)).first();
        if (doc != null) {
            return new Product(doc.getString("_id"), doc.getString("name"), doc.getDouble("price"));
        }
        return null;
    }

    public void saveOrUpdatePayment(Payment payment) {
        Document doc = new Document("_id", payment.getId())
                .append("paymentMethod", payment.getPaymentMethod())
                .append("amount", payment.getAmount());
        
        if (paymentCollection.find(Filters.eq("_id", payment.getId())).first() != null) {
            paymentCollection.replaceOne(Filters.eq("_id", payment.getId()), doc);
        } else {
            paymentCollection.insertOne(doc);
        }
    }

    public Payment findPayment(String id) {
        Document doc = paymentCollection.find(Filters.eq("_id", id)).first();
        if (doc != null) {
            return new Payment(doc.getString("_id"), doc.getString("paymentMethod"), doc.getDouble("amount"));
        }
        return null;
    }

    public void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}