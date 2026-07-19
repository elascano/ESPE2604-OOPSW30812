/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.composite.model;

/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class Teller extends Employee{
    public Teller(String name){
        super(name);
    }
    
    @Override
    protected String getRole(){
        return "Teller";
    }
}
