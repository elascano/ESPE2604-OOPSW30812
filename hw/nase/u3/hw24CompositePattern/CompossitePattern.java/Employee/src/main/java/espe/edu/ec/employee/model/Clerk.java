/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espe.edu.ec.employee.model;

/**
 *
 * @author Jennyfer Nase
 */
public class Clerk extends Employee {

    public Clerk(String aName) {
        this();
        this.name = aName;
    }

    public Clerk() {
        this.title = "Clerk";
    }
    
    @Override
    public void stateName() {
        super.stateName();
    }
}