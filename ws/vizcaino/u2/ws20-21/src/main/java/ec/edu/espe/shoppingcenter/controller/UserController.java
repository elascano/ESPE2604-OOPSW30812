/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.shoppingcenter.controller;

import ec.edu.espe.shoppingcenter.model.User;

/**
 *
 * @author Adrian Vizcaino <The-Softwarrios at ESPE>
 */
public class UserController {
    User user;
    public boolean Login(String username, String password){
     
     //Todo read from dbd
     user = new User(1,"Adrian", "Adrian");
        
      if(user.getUserName().equals(username) &&user.getPassword().equals(password))
          return true;
      else
          return false;
    }
    
}
