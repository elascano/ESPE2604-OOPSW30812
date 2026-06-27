package ec.edu.espe.controller;
import java.util.ArrayList;  
import ec.edu.espe.model.Cut;
import ec.edu.espe.model.SlughterHouse;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Cristian
 */
public interface IMeatAnimal {
     public ArrayList<Cut> cut();
    
    public abstract void sendToSlughterHouse(SlughterHouse slughterHouse);
}

