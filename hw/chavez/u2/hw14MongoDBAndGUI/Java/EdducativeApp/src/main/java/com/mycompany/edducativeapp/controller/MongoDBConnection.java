/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edducativeapp.controller;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoException;
/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class MongoDBConnection {
    private static MongoDBConnection instance;

    public static void getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private MongoClient mongoClient;
    private MongoDatabase database;
    
    private final String CONNECTION_STRING = "mongodb+srv://odalys:odalys@cluster0.2cf9puv.mongodb.net/";
    private final String DATABASE_NAME = "EducativeAppDB";
    
    private MongoDBConnection() {
        try {
            mongoClient = MongoClients.create(CONNECTION_STRING);
            database = mongoClient.getDatabase(DATABASE_NAME);
            System.out.println("Conexión a MongoDB exitosa!");
        } catch (MongoException e) {
            System.err.println("Error al conectar a MongoDB: " + e.getMessage());
        }
    }
    
    public static MongoDBConnection getInstance() {
        if (instance == null) {
            instance = new MongoDBConnection();
        }
        return instance;
    }
    
    public MongoDatabase getDatabase() {
        return database;
    }
    
    public void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Conexión a MongoDB cerrada.");
        }
    }
}
    

