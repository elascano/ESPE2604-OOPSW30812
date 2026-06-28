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
public abstract class FarmAnimal {
    int id;
    String breed;
    Date bornOn;
    float weight;
    
    public int getInMoths(){
        //algorithm to computer the moths based on the date
        return 0;
    }
    
    public abstract void feed(Food food);
}
