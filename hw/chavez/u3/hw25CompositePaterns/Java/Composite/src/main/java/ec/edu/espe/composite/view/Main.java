/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.composite.view;

import ec.edu.espe.composite.controller.EmployeeController;
import ec.edu.espe.composite.model.Employee;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class Main {
    public static void main(String[] args) {

        EmployeeController controller = new EmployeeController();

        Employee organization = controller.createOrganization();

        Client client = new Client(organization);

        client.showOrganization();
    }
    
}
