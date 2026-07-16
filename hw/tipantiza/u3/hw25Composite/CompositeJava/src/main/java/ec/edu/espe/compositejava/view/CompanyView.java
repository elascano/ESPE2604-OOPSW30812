
package ec.edu.espe.compositejava.view;
import ec.edu.espe.compositejava.model.Employee;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */

public class CompanyView {

    public void showOrganization(Employee employee) {


        System.out.println(" COMPANY ORGANIZATION CHART");


        employee.display();
    }
}
