package ec.edu.espe.ws29singletoncalculator.model;

public class USTax {
    private static USTax instance;
    
    private USTax() {
       
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