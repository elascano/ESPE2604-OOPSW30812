package ec.edu.espe.composite;

import ec.edu.espe.composite.model.*;
import ec.edu.espe.composite.view.OrganizationView;
import ec.edu.espe.composite.controller.OrganizationController;

public class Setup {
    public static void main(String args[]) {
        Teller lonny = new Teller("Lonny");
        Clerk cal = new Clerk("Cal");
        Manager able = new Manager("Able");
        able.add(lonny);
        able.add(cal);
        
        Teller juanita = new Teller("Juanita");
        Teller tina = new Teller("Tina");
        Teller thelma = new Teller("Thelma");
        Manager becky = new Manager("Becky");
        becky.add(juanita);
        becky.add(tina);
        becky.add(thelma);
        
        President pete = President.getPresident("Pete");
        pete.add(able);
        pete.add(becky);
        
        OrganizationView view = new OrganizationView();
        OrganizationController controller = new OrganizationController(pete, view);
        
        controller.updateView();
    }
}
