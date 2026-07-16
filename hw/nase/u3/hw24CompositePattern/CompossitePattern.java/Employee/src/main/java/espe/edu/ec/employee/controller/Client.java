/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espe.edu.ec.employee.controller;

import espe.edu.ec.employee.model.Employee;

/**
 *
 * @author Jennyfer Nase
 */
public class Client {
    public static Employee employee;

    public static void doClientTasks() {
        if (employee != null) {
            employee.stateName();
        } else {
            System.out.println("No employee assigned to the client.");
        }
    }
}