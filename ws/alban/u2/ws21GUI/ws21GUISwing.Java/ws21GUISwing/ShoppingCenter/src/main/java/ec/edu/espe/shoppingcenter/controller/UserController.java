
package ec.edu.espe.shoppingcenter.controller;

import ec.edu.espe.shoppingcenter.model.User;

/**
 *
 * @author Christopher Lomas,Polimorphismus ,@ESPE
 */
public class UserController {
    User user;
    
    public boolean login(String userName, String password){
        
        user= new User(1,"Christopher","Christopher");
    
        return user.getUserName().equals(userName) && user.getPassword().equals(password);
    
    }
    
}
