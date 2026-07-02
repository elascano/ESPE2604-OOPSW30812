/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oopconceptszoo.model;

import java.util.Date;

/**
 *
 * @author LABS-ESPE
 */
public abstract class FarmAnimal {
    int id;
    String breed;
    Date bornOn;
    float weigth;
    
    public int getAgeInMonths(){
    return 1;
    }
   
}
