
package ec.edu.espe.safestore.model;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */

public class Product {
    private int id;
    private String name;
    private double wholesalePrice;
    private double retailPrice;
    private int stock;
    private int minStock;
    private String expiryDate;
    
    public Product() {}
    
    public Product(int id, String name, double wholesalePrice, double retailPrice, int stock, int minStock, String expiryDate) {
        this.id = id;
        this.name = name;
        this.wholesalePrice = wholesalePrice;
        this.retailPrice = retailPrice;
        this.stock = stock;
        this.minStock = minStock;
        this.expiryDate = expiryDate;
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getWholesalePrice() { return wholesalePrice; }
    public void setWholesalePrice(double wholesalePrice) { this.wholesalePrice = wholesalePrice; }
    public double getRetailPrice() { return retailPrice; }
    public void setRetailPrice(double retailPrice) { this.retailPrice = retailPrice; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public int getMinStock() { return minStock; }
    public void setMinStock(int minStock) { this.minStock = minStock; }
    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }
    
    public double getPriceByQuantity(int quantity) {
        return (quantity >= 12) ? wholesalePrice : retailPrice;
    }
    
    @Override
    public String toString() {
        return "Product{id=" + id + ", name=" + name + ", stock=" + stock + ", retailPrice=" + retailPrice + "}";
    }
}
