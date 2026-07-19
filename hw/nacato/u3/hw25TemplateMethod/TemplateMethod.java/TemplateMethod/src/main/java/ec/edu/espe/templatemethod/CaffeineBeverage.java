/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.templatemethod;

import java.util.Scanner;

/**
 *
 * @author Angie Ñacato, Error 404, @ESPE
 */
public abstract class CaffeineBeverage {
    
    public void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if(wantsCondiments()){
            addCondiments();
        }
        
    }
    
    public void boilWater(){
        System.out.println("Boiling Water");
    }
    
    public abstract void brew();
    
    public void pourInCup(){
        System.out.println("Pouring into cup");
    }
    
    public boolean wantsCondiments(){
        String answer = getUserInput();
        boolean decision;
        if(answer.equalsIgnoreCase("y")){
            decision = true;
        }else{
            decision = false;
        }
        return decision;
    }
    
    public abstract void addCondiments();
    
    public abstract String getUserInput();
}
