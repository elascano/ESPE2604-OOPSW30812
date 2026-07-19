/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.composite.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class Supervisor extends Employee{
    
    protected final List<Employee> subordinates = new ArrayList<>();
    
    public Supervisor(String name){
        super(name);
    }
    
    @Override
    protected String getRole() {
        return "Supervisor";
    }

    public void addEmployee(Employee employee) {
        subordinates.add(employee);
    }

    public void removeEmployee(Employee employee) {
        subordinates.remove(employee);
    }

    @Override
    public void stateName() {
        super.stateName();
        for (Employee employee : subordinates) {
            employee.stateName();
        }
    }
}
