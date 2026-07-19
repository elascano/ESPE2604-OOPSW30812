/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.compositepattern.model;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public abstract class Employee {

    protected String name = "Not assigned yet";
    protected String title = "Not asigned yet";

    public void stateName(){
        System.out.println(title + " " + name);
    }
}
