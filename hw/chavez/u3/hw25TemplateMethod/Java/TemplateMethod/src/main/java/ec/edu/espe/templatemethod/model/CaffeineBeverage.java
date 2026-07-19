/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.templatemethod.model;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public abstract class CaffeineBeverage {
    
    // Template Method: fixed algorithm
    public void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (wantsCondiments()) {
            addCondiments();
        }
    }

    public void boilWater() {
        System.out.println("Boiling water");
    }

    public abstract void brew();

    public void pourInCup() {
        System.out.println("Pouring into cup");
    }

    public abstract void addCondiments();

    // Hook operation: default behavior
    public boolean wantsCondiments() {
        return true;
    }
}
