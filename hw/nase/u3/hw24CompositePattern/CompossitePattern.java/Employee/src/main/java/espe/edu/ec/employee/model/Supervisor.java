/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espe.edu.ec.employee.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jennyfer Nase
 */
public abstract class Supervisor extends Employee {
    protected List<Employee> directReports = new ArrayList<>();

    @Override
    public void stateName() {
        super.stateName(); 
        if (!directReports.isEmpty()) {
            for (Employee emp : directReports) {
                emp.stateName();
            }
        }
    }

    public void add(Employee anEmployee) {
        this.directReports.add(anEmployee);
    }
}