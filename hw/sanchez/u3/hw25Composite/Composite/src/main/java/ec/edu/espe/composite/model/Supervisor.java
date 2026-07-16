/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.composite.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */


public abstract class Supervisor extends Employee {

    protected List<Employee> employees;

    public Supervisor(String name, String title) {
        super(name, title);
        employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void remove(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public void display() {

        System.out.println(title + ": " + name);

        for (Employee employee : employees) {
            employee.display();
        }
    }
}