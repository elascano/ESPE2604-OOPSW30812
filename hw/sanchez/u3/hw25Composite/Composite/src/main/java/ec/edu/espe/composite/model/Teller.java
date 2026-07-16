/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.composite.model;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */


public class Teller extends Employee {

    public Teller(String name) {
        super(name, "Teller");
    }

    @Override
    public void display() {
        System.out.println(title + ": " + name);
    }
}
