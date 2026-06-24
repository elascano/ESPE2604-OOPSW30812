/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.model;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class User {

    private String name;
    private String plan;

    public User(String name, String plan) {
        this.name = name;
        this.plan = plan;
    }

    public String getName() {
        return name;
    }

    public String getPlan() {
        return plan;
    }
}