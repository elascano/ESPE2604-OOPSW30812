/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.chikenSimulation.model;

/**
 *
 * @author Jennyfer Nase
 */
public class Chicken {
    
    public String name;
    public int ageInMonths;
    public int drinkWater = 0;
    public int eggCounter = 0;
    public int dailyFood = 50;
    public int wanderCounter = 0;

    
    @Override
    public String toString() {
        return "Chicken{" + "name=" + name + ", age=" + ageInMonths + 
               ", food=" + dailyFood + ", eggs=" + eggCounter + '}';
    }
}