/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.tax;

/**
 *
 * @author Odalys Chavez , CodeBreakers, @ESPE
 */
public class Tax {
    private static Tax instance;
    private float percentage;
    
    
   private Tax(){
        percentage=0.15F;
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

    public float salesTotal(float amount) {
        
        
        return amount + (amount*percentage/100);
    }
}
