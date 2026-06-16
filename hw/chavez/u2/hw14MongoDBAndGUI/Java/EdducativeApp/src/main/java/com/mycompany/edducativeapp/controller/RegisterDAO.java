/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edducativeapp.controller;

import com.mycompany.edducativeapp.model.Register;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;



/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class RegisterDAO {
    private MongoCollection<Document> collection;
    
    public RegisterDAO() {
        MongoDatabase database = MongoDBConnection.getInstance().getDatabase();
        this.collection = database.getCollection("registers");
    }
    
    public boolean createRegister(Register register) {
        try {
            Document doc = register.toDocument();
            collection.insertOne(doc);
            register.setId(doc.getObjectId("_id").toString());
            return true;
        } catch (Exception e) {
            System.err.println("Error al crear registro: " + e.getMessage());
            return false;
        }
    }
    
    public Register findRegisterByUsername(String username) {
        try {
            Document doc = collection.find(Filters.eq("username", username)).first();
            if (doc != null) {
                return Register.fromDocument(doc);
            }
        } catch (Exception e) {
            System.err.println("Error al buscar registro: " + e.getMessage());
        }
        return null;
    }
    
    public boolean verifyCredentials(String username, String password) {
        try {
            Document doc = collection.find(Filters.and(
                Filters.eq("username", username),
                Filters.eq("password", password)
            )).first();
            return doc != null;
        } catch (Exception e) {
            System.err.println("Error al verificar credenciales: " + e.getMessage());
            return false;
        }
    }
}
