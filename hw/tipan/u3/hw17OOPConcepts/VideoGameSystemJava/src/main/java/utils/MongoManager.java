/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoManager {

    private static final String URI = "mongodb+srv://Ronald:Ronald@cluster0.cd2ybxo.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

    public static MongoDatabase getDatabase() {

        MongoClient mongoClient = MongoClients.create(URI);

        return mongoClient.getDatabase("VideoGameDB");
    }
}