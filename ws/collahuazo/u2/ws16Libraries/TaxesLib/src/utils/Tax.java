package utils;

/**
 *
 * @author Collahuazo Brandon, CodeBros , @ESPE
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
