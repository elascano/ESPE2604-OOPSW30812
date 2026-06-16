/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edducativeapp.model;

import java.util.Date;
import org.bson.Document;


/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class Register {
    private String id;
    private String username;
    private String password;
    private String email;
    private Date registrationDate;
    private String userType; // "Student" o "Teacher"
    
    // Constructores
    public Register() {}
    
    public Register(String username, String password, String email, String userType) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userType = userType;
        this.registrationDate = new Date();
    }
    
    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public Date getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(Date registrationDate) { this.registrationDate = registrationDate; }
    
    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }
    
    // Convertir a Document para MongoDB
    public Document toDocument() {
        return new Document("username", username)
                .append("password", password)
                .append("email", email)
                .append("registrationDate", registrationDate)
                .append("userType", userType);
    }
    
    // Crear desde Document
    public static Register fromDocument(Document doc) {
        Register register = new Register();
        register.setId(doc.getObjectId("_id").toString());
        register.setUsername(doc.getString("username"));
        register.setPassword(doc.getString("password"));
        register.setEmail(doc.getString("email"));
        register.setRegistrationDate(doc.getDate("registrationDate"));
        register.setUserType(doc.getString("userType"));
        return register;
    }
    
}
