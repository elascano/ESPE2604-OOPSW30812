/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.compositepattern.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Supervisor extends Employee {

    protected List<Employee> directReports;

    public Supervisor() {
        directReports = new ArrayList<>();
    }

    public Supervisor(String name, String title) {
        super(name, title);
        directReports = new ArrayList<>();
    }

    public void add(Employee employee) {
        directReports.add(employee);
    }

    public List<Employee> getDirectReports() {
        return directReports;
    }

    @Override
    public void stateName() {

        super.stateName();

        for (Employee employee : directReports) {
            employee.stateName();
        }

    }

}