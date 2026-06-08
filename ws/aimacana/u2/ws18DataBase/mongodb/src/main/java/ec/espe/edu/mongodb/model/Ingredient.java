package ec.espe.edu.mongodb.model;

import java.math.BigDecimal;

/**
 * Ingredient representation for MongoDB tests.
 * 
 * @author Anthony Aimacaña, MKA programmer, @ESPE
 */
public class Ingredient {
    private String ingredientId;
    private String name;
    private BigDecimal stockQuantity;
    private String unit;
    private BigDecimal minimumAlertQuantity;

    public Ingredient() {
        this.stockQuantity = BigDecimal.ZERO;
        this.minimumAlertQuantity = BigDecimal.ZERO;
    }

    public Ingredient(String ingredientId, String name, BigDecimal stockQuantity, String unit, BigDecimal minimumAlertQuantity) {
        this.ingredientId = ingredientId;
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.unit = unit;
        this.minimumAlertQuantity = minimumAlertQuantity;
    }

    public String getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(String ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(BigDecimal stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getMinimumAlertQuantity() {
        return minimumAlertQuantity;
    }

    public void setMinimumAlertQuantity(BigDecimal minimumAlertQuantity) {
        this.minimumAlertQuantity = minimumAlertQuantity;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientId='" + ingredientId + '\'' +
                ", name='" + name + '\'' +
                ", stockQuantity=" + stockQuantity +
                ", unit='" + unit + '\'' +
                ", minimumAlertQuantity=" + minimumAlertQuantity +
                '}';
    }
}
