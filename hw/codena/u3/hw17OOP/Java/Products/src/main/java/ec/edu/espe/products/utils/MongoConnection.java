/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.products.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */

public class MongoConnection {

    private static final String URI = "mongodb+srv://daniel:daniel1234@cluster0.zfwd5wx.mongodb.net/?appName=Cluster0";

    private static final String DATABASE_NAME = "Store";

    private MongoClient client;
    private MongoDatabase database;

    public MongoConnection() {

        try {

            client = MongoClients.create(URI);

            database = client.getDatabase(DATABASE_NAME);

            System.out.println("Connected successfully.");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void closeConnection() {

        if (client != null) {
            client.close();
        }

    }

}