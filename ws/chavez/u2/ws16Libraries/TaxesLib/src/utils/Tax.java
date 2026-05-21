/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class Tax {
    public static float computeIva(float amount, float taxPercentage){
        float taxValue;
        taxValue=amount * taxPercentage/100;
        return taxValue;   
    }
    
    public static float computeTotal(float amount, float taxPercentage){
        float totalValue;
        totalValue = amount + computeIva(amount, taxPercentage);
        return totalValue;
    }
    
}
