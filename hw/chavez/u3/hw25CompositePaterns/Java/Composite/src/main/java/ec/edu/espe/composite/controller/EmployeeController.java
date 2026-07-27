/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.composite.controller;

import ec.edu.espe.composite.model.*;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class EmployeeController {
    public Employee createOrganization() {

        Manager able = new Manager("Able");

        able.add(new Teller("Lonny"));
        able.add(new Clerk("Cal"));

        Manager becky = new Manager("Becky");

        becky.add(new Teller("Juanita"));
        becky.add(new Teller("Tina"));
        becky.add(new Teller("Thelma"));

        President pete = new President("Pete");

        pete.add(able);
        pete.add(becky);

        return pete;
    }
}
