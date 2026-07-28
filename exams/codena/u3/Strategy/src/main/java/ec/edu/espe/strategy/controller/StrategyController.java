/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.strategy.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.strategy.utils.MongoConnection;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

/**
 *
 * @author Daniel Codena, @CodeBreakers, ESPE
 */
public class StrategyController {
    private MongoConnection connection;

    public StrategyController() {
        connection = new MongoConnection();
    }

    public void create(ArrayList<Object> numbers, SortingStrategy strategy) {

        MongoDatabase database = connection.getDatabase();
        MongoCollection<Document> collection = database.getCollection("arrayDaniel");
        Document document = new Document();

        document.append("unsorted", numbers);
        document.append("size", numbers.size());
        document.append("sortAlgorithm", strategy.sort(numbers));
    }
}
