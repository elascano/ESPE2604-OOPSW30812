/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.composite.model;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */

public abstract class Employee {

    protected String name;
    protected String title;

    public Employee(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public abstract void display();
}
