/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.compositepattern.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public abstract class Supervisor extends Employee {

    protected List<Employee> directReports = new ArrayList<>();

    public void stateName() {
        super.stateName();
        for (Employee employee : directReports) {
            employee.stateName();
        }
    }

    public void add(Employee employee) {
        directReports.add(employee);
    }
}
