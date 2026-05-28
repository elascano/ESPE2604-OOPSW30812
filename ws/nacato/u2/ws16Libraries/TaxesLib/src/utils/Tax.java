package utils;

/**
 *
 * @author Angie Nacato, Error 404, @ESPE
 */
public class Tax {
    public static float computeIva(float amount,float taxPercentage){
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
