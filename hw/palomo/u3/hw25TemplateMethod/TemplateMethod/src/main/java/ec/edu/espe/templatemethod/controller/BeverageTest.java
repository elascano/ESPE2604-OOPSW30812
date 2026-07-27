/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.templatemethod.controller;

import ec.edu.espe.templatemethod.model.Coffee;
import ec.edu.espe.templatemethod.model.Tea;
import ec.edu.espe.templatemethod.view.BeverageView;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
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
