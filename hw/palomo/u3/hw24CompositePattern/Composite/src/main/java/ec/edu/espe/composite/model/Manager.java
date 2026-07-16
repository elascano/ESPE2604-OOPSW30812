/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.composite.model;

/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class Manager extends Supervisor{
    public Manager(String name){
        super(name);
    }
    
    @Override
    protected  String getRole(){
        return "Manager";
    }
}
