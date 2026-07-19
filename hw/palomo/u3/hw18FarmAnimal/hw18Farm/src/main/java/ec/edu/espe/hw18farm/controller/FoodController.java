/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.hw18farm.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import ec.edu.espe.hw18farm.model.Food;
import ec.edu.espe.hw18farm.utils.MongoConnection;
import java.util.ArrayList;
import org.bson.Document;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class FoodController {
    private MongoCollection<Document> collection;

    public FoodController() {
        collection = MongoConnection.getDatabase().getCollection("foods");
    }

    public void create(Food food) {
        Document document = new Document();

        document.append("_id", food.getId());
        document.append("typeOfFood", food.getTypeOfFood().toString());

        collection.insertOne(document);
    }

    public void update(Food food) {
        collection.updateOne(
                Filters.eq("_id", food.getId()),
                Updates.set("typeOfFood", food.getTypeOfFood())
        );
    }

    public void delete(int id) {
        collection.deleteOne(Filters.eq("_id", id));
    }

    public ArrayList<Food> read() {
        ArrayList<Food> foods = new ArrayList<>();

        FindIterable<Document> documents = collection.find();

        for (Document doc : documents) {
            int id = doc.getInteger("_id");
            String typeOfFood = doc.getString("typeOfFood");

            foods.add(new Food(id, typeOfFood));
        }

        return foods;
    }

    public Food findById(int id) {
        Document document = collection.find(Filters.eq("_id", id)).first();

        if (document == null) {
            return null;
        }

        String typeOfFood = document.getString("typeOfFood");
        Food food = new Food(id, typeOfFood);

        return food;
    }
}
