/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.composite.controller;

import ec.edu.espe.composite.model.Employee;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class Client {
    private final Employee root;
    
    public Client(Employee root){
        this.root = root;
    } 
    
    public void showOrganizationalChart(){
        root.stateName();
    }
}
