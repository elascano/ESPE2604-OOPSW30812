/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class ChickenFarmSimulator {
    public static void main(String[] args) {
        Chicken chicken;
        chicken = new Chicken(1, "Lucy", "White and brown", 1, true);
        System.out.println("my chicken --- " + chicken);
    }
}
