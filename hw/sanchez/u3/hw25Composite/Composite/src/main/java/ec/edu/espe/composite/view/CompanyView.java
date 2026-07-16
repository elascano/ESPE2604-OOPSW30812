/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.composite.view;

import ec.edu.espe.composite.model.Employee;
/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */


public class CompanyView {

    public void showOrganization(Employee employee) {


        System.out.println(" COMPANY ORGANIZATION CHART");


        employee.display();
    }
}
