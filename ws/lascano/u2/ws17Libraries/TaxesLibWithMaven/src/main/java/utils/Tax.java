package utils;

/**
 *
 * @author Edison Lascano, Object Masters, @ESPE
 */
public class Tax {
    public static float computeIva(float amount, float taxPercentage){
        float taxValue;
        taxValue = amount * taxPercentage/100;
        return taxValue;
    }
    
    public static float computeTotal(float amount, float taxPercentage){
        float totalValue;
        totalValue = amount + computeIva(amount, taxPercentage);
        return totalValue;
    }
}
