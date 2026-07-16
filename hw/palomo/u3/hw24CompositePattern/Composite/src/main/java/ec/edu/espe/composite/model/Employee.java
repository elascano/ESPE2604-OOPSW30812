/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.composite.model;

/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public abstract class Employee {
    
    protected final String name;
    
    protected Employee(String name){
        this.name = name;
    }
    
    protected abstract String getRole();
    
    public void stateName(){
        System.out.println(name + "-" + getRole());
    }
    
    public String getName(){
        return name;
    }
}
