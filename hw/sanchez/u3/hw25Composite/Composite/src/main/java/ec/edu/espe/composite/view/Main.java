/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.composite.view;

import ec.edu.espe.composite.controller.CompanyController;
import ec.edu.espe.composite.model.*;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */

public class Main {

    public static void main(String[] args) {

    President president = new President("Pete");

    Manager able = new Manager("Able");
    Manager becky = new Manager("Becky");
    Manager john = new Manager("John");
    Manager sarah = new Manager("Sarah");

    Teller lonny = new Teller("Lonny");
    Teller juanita = new Teller("Juanita");
    Teller tina = new Teller("Tina");
    Teller thelma = new Teller("Thelma");
    Teller michael = new Teller("Michael");
    Teller david = new Teller("David");

    Clerk cal = new Clerk("Cal");
    Clerk emma = new Clerk("Emma");
    Clerk oliver = new Clerk("Oliver");

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