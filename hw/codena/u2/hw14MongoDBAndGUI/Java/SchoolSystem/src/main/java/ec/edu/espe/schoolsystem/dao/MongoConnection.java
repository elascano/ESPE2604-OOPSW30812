/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsystem.dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class MongoConnection {

    private static final String URI =
            "URI";

    private static final String DATABASE =
            "SchoolSystem";

    private static final MongoClient client =
            MongoClients.create(URI);

    public static MongoDatabase getDatabase() {
        return client.getDatabase(DATABASE);
    }
}