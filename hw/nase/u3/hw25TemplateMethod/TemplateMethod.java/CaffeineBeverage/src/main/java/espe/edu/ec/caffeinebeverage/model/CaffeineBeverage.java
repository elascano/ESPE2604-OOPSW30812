/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espe.edu.ec.caffeinebeverage.model;

/**
 *
 * @author Jennyfer Nase 
 */
public abstract class CaffeineBeverage {
    
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (wantsCondiments()) { 
            addCondiments(); 
        }
    }
    
    void boilWater() { 
        System.out.println("Boiling water"); 
    }
    
    void pourInCup() { 
        System.out.println("Pouring into cup"); 
    }
    
    protected abstract void brew();
    protected abstract void addCondiments();
    
    protected boolean wantsCondiments() { 
        return true; 
    }
}