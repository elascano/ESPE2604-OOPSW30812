/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espe.edu.ec.employee.model;

/**
 *
 * @author Jennyfer Nase
 */
public class Manager extends Supervisor {
    
    public Manager(String aName) {
        this();
        this.name = aName;
    }

    public Manager() {
        super();
        this.title = "Manager";
    }

    @Override
    public void stateName() {
        super.stateName();
    }
}