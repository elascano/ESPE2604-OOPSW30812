package ec.edu.espe.composite.controller;

import ec.edu.espe.composite.model.Employee;
import ec.edu.espe.composite.view.OrganizationView;

public class OrganizationController {
    private Employee model;
    private OrganizationView view;

    public OrganizationController(Employee model, OrganizationView view) {
        this.model = model;
        this.view = view;
    }
    
    public void updateView() {
        view.printOrganization(model.stateName());
    }
}
