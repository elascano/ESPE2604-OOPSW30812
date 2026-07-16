
package ec.edu.espe.compositejava.view;
import ec.edu.espe.compositejava.model.Teller;
import ec.edu.espe.compositejava.model.President;
import ec.edu.espe.compositejava.model.Manager;
import ec.edu.espe.compositejava.model.Clerk;
import ec.edu.espe.compositejava.controller.CompanyController;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */

public class Main {

    public static void main(String[] args) {

    President president = new President("Alex");

    Manager able = new Manager("Sandra");
    Manager becky = new Manager("Nathalia");
    Manager john = new Manager("German");
    Manager sarah = new Manager("Henry");

    Teller lonny = new Teller("Roxy");
    Teller juanita = new Teller("Lenny");
    Teller tina = new Teller("Sonia");
    Teller thelma = new Teller("Tania");
    Teller michael = new Teller("Stefany");
    Teller david = new Teller("Evelyn");

    Clerk cal = new Clerk("Jorge");
    Clerk emma = new Clerk("DennisS");
    Clerk oliver = new Clerk("Ommar");

    able.add(lonny);
    able.add(cal);

    becky.add(juanita);
    becky.add(tina);

    john.add(thelma);
    john.add(emma);

    sarah.add(michael);
    sarah.add(david);
    sarah.add(oliver);

    president.add(able);
    president.add(becky);
    president.add(john);
    president.add(sarah);

    CompanyView view = new CompanyView();

    CompanyController controller =
            new CompanyController(president, view);

    controller.displayOrganization();
}
}