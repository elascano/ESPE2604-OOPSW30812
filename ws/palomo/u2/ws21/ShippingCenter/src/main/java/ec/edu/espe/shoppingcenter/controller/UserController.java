/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.shoppingcenter.controller;
import ec.edu.espe.shoppingcenter.model.User;
/**
 *
 * @author Cristian Palmo,Error 404 @ESPE
 */
public class UserController {
    User user;
    public boolean login(String userName, String password){
        user = new User (1, "Cristian", "Cristian");
        return user.getUserName().equals(userName)&& user.getPassword().equals(password);
    }
}
