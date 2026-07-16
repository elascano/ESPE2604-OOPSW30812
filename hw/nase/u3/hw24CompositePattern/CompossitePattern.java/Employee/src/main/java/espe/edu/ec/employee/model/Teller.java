/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espe.edu.ec.employee.model;

/**
 *
 * @author Jennyfer Nase
 */
public class Teller extends Employee {

    public Teller(String aName) {
        this();
        this.name = aName;
    }

    public Teller() {
        this.title = "Teller";
    }

    @Override
    public void stateName() {
        super.stateName();
    }
}