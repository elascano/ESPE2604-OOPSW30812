/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.shoppingcenter.controller;

import ec.edu.espe.shoppingcenter.model.User;

/**
 *
 * @author Ronald Tipan <The_Softwarrios at ESPE>
 */
public class UserController {
    User user;
    
    public boolean login(String userName, String password){
        if (user != null && user.getUser().equals(userName) && user.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
    
    // Este método ya lo tienes
    public void setUser(User user) {
        this.user = user;
    }
}