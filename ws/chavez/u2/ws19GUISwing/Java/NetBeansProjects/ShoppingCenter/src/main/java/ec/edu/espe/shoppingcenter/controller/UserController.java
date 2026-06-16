/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.shoppingcenter.controller;

import ec.edu.espe.shoppingcenter.model.User;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class UserController {
    
    User user;
    public boolean logic(String userName,String password){
        //TODO read from DB
        //call to method to read from DB that in the utils package
        //using the JSON string build an object of type User
        user= new User(1,"Odalys","Odalys");
        return user.getUserName().equals(userName)&& user.getPassword().equals(password);
    }
    
}
