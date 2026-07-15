/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.tax;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Tax {
    private static  Tax instance;
    
    private float percentage;


    
    private Tax(){
        System.out.println("\nInitializing instance\n");
    }
    
    public void updateTaxPercentage(float p){
        
        percentage = p;
    }
    
    public static Tax getInstance(){
        if(instance == null){
            instance = new Tax();
        }
        
        return instance;
    }
    
    public float getPercentage(){
        return percentage;
    }
    
    public float salesTotal(float price){
        float calculatedPrice = price * percentage;
        return calculatedPrice;
    }
}
