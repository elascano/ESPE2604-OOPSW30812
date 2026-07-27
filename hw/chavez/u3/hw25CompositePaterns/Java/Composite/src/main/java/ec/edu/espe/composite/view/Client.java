/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.composite.view;

import ec.edu.espe.composite.model.Employee;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class Client {
     private Employee employee;

    public Client(Employee employee) {
        this.employee = employee;
    }

    public void showOrganization() {
        employee.stateName();
    }
    
}
