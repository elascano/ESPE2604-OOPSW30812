/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.shoppingstore.controller;

import ec.edu.espe.shoppingstore.model.User;

/**
 *
 * @author Collahuazo Brandon, CodeBros, @ESPE
 */
public class UserController {

    User user;

    public boolean login(String userName, String password) {
        
        //TODO read from db
        //call to method to read from DB that is in the utils package
        //Using the JSON string build an object of type user
        
        user = new User(1, "Brandon", "Brandon");
        
        return user.getUserName().equals(userName) && user.getPassword().equals(password);
    }

}
