/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oopconceptszoo.model;

import java.util.Date;

/**
 * @author Joel Sanchez, The Softwarriors, @ESPE
 *
 */
public class Sheep extends FarmAnimal{
    Date lastSheering;
    @Override
    public void food(Food food) {
        System.out.println("feddomt a sjeep with" +food);
    }
    
}
