/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.templatemethod.view;

import ec.edu.espe.templatemethod.model.CaffeineBeverage;
import ec.edu.espe.templatemethod.model.Coffee;
import ec.edu.espe.templatemethod.model.Tea;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class BeverageTest {

    public static void main(String[] args) {

        CaffeineBeverage tea = new Tea();
        tea.prepareRecipe();

        System.out.println();

        CaffeineBeverage coffee = new Coffee();
        coffee.prepareRecipe();
    }
}