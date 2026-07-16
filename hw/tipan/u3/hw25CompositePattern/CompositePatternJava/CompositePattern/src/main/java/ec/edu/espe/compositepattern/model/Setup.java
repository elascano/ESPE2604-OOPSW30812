/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.compositepattern.model;

public class Setup {

    public void buildOrganization() {

        Teller lonny = new Teller("Lonny");
        Clerk cal = new Clerk("Cal");
        Teller susan = new Teller("Susan");
        Clerk david = new Clerk("David");

        Manager able = new Manager("Able");
        able.add(lonny);
        able.add(cal);
        able.add(susan);
        able.add(david);

        Teller juanita = new Teller("Juanita");
        Teller tina = new Teller("Tina");
        Teller thelma = new Teller("Thelma");
        Clerk kevin = new Clerk("Kevin");
        Clerk laura = new Clerk("Laura");

        Manager becky = new Manager("Becky");
        becky.add(juanita);
        becky.add(tina);
        becky.add(thelma);
        becky.add(kevin);
        becky.add(laura);

        Teller robert = new Teller("Robert");
        Teller emily = new Teller("Emily");
        Clerk sophia = new Clerk("Sophia");
        Clerk daniel = new Clerk("Daniel");

        Manager michael = new Manager("Michael");
        michael.add(robert);
        michael.add(emily);
        michael.add(sophia);
        michael.add(daniel);

        President pete = President.getPresident("Pete");
        pete.add(able);
        pete.add(becky);
        pete.add(michael);

        pete.stateName();
    }

}
