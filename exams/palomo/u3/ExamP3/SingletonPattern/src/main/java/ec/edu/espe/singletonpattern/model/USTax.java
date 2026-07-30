/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.singletonpattern.model;

/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class USTax {
    private static USTax instance;
    
    public USTax() {
    }
    
    public static USTax getInstance() {
        if (instance == null) {
            instance = new USTax();
        }
        return instance;
    }
    
    public float salesTotal() {
        float taxRate = 0.12f;
        float subtotal = 100.0f;
        return subtotal + (subtotal * taxRate);
    }

    public float calculateTax(float amount, float taxRate) {
        return amount + (amount * (taxRate / 100));
    }
}
