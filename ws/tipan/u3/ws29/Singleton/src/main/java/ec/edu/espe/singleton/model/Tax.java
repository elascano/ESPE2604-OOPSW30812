/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.singleton.model;

/**
 *
 * @author Ronald Tipan, The_Softwarriors ,@ESPE
 */
public class Tax {

    private static Tax instance;
    private float percentage;

    private Tax() {
        percentage = 15.0f;
    }

    public static Tax getInstance() {
        if (instance == null) {
            instance = new Tax();
        }
        return instance;
    }

    public void updateTaxPercentage(float p) {
        percentage = p;
    }

    public float getPercentage() {
        return percentage;
    }

    public float salesTotal(float subtotal) {
        return subtotal + (subtotal * percentage / 100);
    }
}

