/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espe.edu.ec.employee.view;

import espe.edu.ec.employee.controller.Client;
import espe.edu.ec.employee.model.Clerk;
import espe.edu.ec.employee.model.Manager;
import espe.edu.ec.employee.model.President;
import espe.edu.ec.employee.model.Teller;

/**
 *
 * @author Jennyfer Nase
 */
public class Setup {

    public static void main(String[] args) {
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

        Client.employee = pete;
        Client.doClientTasks();
    }
}