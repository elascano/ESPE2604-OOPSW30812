/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.composite.model;

import java.util.ArrayList;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public abstract class Supervisor extends Employee{

    protected ArrayList<Employee> directReports;

    public Supervisor(String name, String title) {
        super(name, title);
        directReports = new ArrayList<>();
    }
     public void add(Employee employee) {
        directReports.add(employee);
    }
     @Override
    public void stateName() {
        super.stateName();

        for (Employee employee : directReports) {
            employee.stateName();
        }
    }

    
}
