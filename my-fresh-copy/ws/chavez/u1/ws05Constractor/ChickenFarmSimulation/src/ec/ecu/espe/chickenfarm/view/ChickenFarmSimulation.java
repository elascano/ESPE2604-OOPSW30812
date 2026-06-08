/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.ecu.espe.chickenfarm.view;

import ec.ecu.espe.chickenfarm.model.Chicken;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class ChickenFarmSimulation {
     public static void main(String[] args) {
        Chicken chicken;
        chicken = new Chicken(1,"Lucy","White and brown",1,true);
        System.out.println("My chicken is -->" + chicken);
    }
    
}
