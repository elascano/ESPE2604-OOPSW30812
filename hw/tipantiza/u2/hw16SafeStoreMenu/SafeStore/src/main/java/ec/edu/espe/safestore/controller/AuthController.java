
package ec.edu.espe.safestore.controller;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */
import ec.edu.espe.safestore.model.User;
import java.util.ArrayList;
import java.util.List;

public class AuthController {
    
    private List<User> users;
    
    public AuthController() {
        users = new ArrayList<>();
        loadDefaultUsers();
    }
    
    private void loadDefaultUsers() {
        users.add(new User("gerente", "1234", "Manager"));
        users.add(new User("admin", "admin", "Manager"));
        users.add(new User("cajero1", "1234", "Cashier"));
        users.add(new User("cajero", "cajero", "Cashier"));
    }
    
    public boolean authenticate(String username, String password, String role) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username) && 
                user.getPassword().equals(password) && 
                user.getRole().equals(role)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean addUser(String username, String password, String role) {
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                return false;
            }
        }
        users.add(new User(username, password, role));
        return true;
    }
    
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}
