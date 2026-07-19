/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.composite.view;

import ec.edu.espe.composite.controller.Client;
import ec.edu.espe.composite.model.Clerk;
import ec.edu.espe.composite.model.Manager;
import ec.edu.espe.composite.model.President;
import ec.edu.espe.composite.model.Supervisor;
import ec.edu.espe.composite.model.Teller;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class Setup {
    
    public static void main(String[] args){
        
        Clerk clerk1 = new Clerk("Juliana");
        Clerk clerk2 = new Clerk("Camila");
        Teller teller1 = new Teller("Margarita");
        
        Supervisor supervisor = new Supervisor("Carlos");
        supervisor.addEmployee(clerk1);
        supervisor.addEmployee(clerk2);
        supervisor.addEmployee(teller1);
        
        
        Manager manager = new Manager("Betsua");
        manager.addEmployee(supervisor);
        
        President president = new President("Juan");
        president.addEmployee(manager);
        
        Client client = new Client(president);
        client.showOrganizationalChart();
    }
}
