/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.composite.controller;

import ec.edu.espe.composite.model.Employee;
import ec.edu.espe.composite.view.CompanyView;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */


public class CompanyController {

    private Employee organization;
    private CompanyView view;

    public CompanyController(Employee organization, CompanyView view) {
        this.organization = organization;
        this.view = view;
    }

    public void displayOrganization() {
        view.showOrganization(organization);
    }
}
