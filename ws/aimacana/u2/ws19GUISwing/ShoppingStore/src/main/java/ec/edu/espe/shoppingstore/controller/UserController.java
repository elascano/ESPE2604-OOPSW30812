/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.shoppingstore.controller;

import ec.edu.espe.shoppingstore.model.User;

/**
 *
 * @author Anthony Aimacaña, MKA programer, @ESPE
 */
public class UserController {
    
    User user;
    public boolean login(String userName, String password){
        
        //TODO read from DB
        //call to method to read JSON from DB that is in
        user = new User(1,"Anthony","Anthony");
        
        return user.getUserName().equals(userName) && user.getPassword().equals(password);
    }
}
