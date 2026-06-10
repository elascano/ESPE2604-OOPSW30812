/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.safestore.model;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class User {
    private String userName;
    private String password;
    private String role;
    
    public User() {}
    
    public User(String username, String password, String role) {
        this.userName = username;
        this.password = password;
        this.role = role;
    }
    
    public String getUsername() { return userName; }
    public void setUsername(String username) { this.userName = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    
    @Override
    public String toString() {
        return "User{username=" + userName + ", role=" + role + "}";
    }
}
