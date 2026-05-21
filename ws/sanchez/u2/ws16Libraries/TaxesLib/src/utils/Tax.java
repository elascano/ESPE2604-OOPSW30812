/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author Joel Sanchez <The_Softwarriors at ESPE>
 */
public class Tax {
    public static float computeIva(float amount, float taxPorcentage){
       float taxValue;
       taxValue = amount * taxPorcentage/100;
       return taxValue;
    }
    
    public static float computeTotal(float amount, float taxPorcentage){
        float totalValue;
        totalValue = amount + computeIva(amount, taxPorcentage);
        return totalValue;
    }
}
