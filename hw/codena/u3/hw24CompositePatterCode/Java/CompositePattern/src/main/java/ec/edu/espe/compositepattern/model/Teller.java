/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.compositepattern.model;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Teller extends Employee{

    public Teller(String aName) {
        this();
        name = aName;
    }
    
    public Teller(){
        title = "Teller";
    }
    
    public void stateName(){
        super.stateName();
    }
}
