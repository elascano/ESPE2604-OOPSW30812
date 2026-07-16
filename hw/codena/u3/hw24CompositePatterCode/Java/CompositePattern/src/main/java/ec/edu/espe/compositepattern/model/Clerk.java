/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.compositepattern.model;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Clerk extends Employee {

    public Clerk(String aName) {
        this();
        name = aName;
    }

    public Clerk() {
        title = "Clerk";
    }

    public void stateName() {
        super.stateName();
    }
}
