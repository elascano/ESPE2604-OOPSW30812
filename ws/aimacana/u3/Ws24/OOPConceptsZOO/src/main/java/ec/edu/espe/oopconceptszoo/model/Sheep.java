/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oopconceptszoo.model;

import java.util.Date;

/**
 *
 * @author Ronald Tipan <The_Softwarrios at ESPE>
 */
public class Sheep extends FarmAnimal {
    Date lastSheering;

    @Override
    public void feed(Food food) {
        System.out.println("Feeding a Sheep with " + food);
    }
    
}
