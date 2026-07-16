
package ec.edu.espe.compositejava.controller;
import ec.edu.espe.compositejava.model.Employee;
import ec.edu.espe.compositejava.view.CompanyView;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
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
