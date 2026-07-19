/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espe.edu.ec.caffeinebeverage.controller;

import espe.edu.ec.caffeinebeverage.model.Coffee;
import espe.edu.ec.caffeinebeverage.model.Tea;
import espe.edu.ec.caffeinebeverage.view.BeverageView;

/**
 *
 * @author Jennyfer Nase 
 */
public class BeverageTest {
    public static void main(String[] args) {
        BeverageView view = new BeverageView();
        
        Tea tea = new Tea();
        Coffee coffee = new Coffee();
        
        view.printMessage("\nMaking tea ...");
        tea.prepareRecipe();
        
        view.printMessage("\nMaking coffee ...");
        coffee.prepareRecipe();
    }
}
