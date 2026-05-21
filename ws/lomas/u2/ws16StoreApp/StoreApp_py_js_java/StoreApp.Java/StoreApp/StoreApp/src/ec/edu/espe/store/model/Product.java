
package ec.edu.espe.store.model;

import utils.Tax;

/**
 *
 * @author LABS-ESPE
 */
public class Product {
    int id;
    String description;
    float price;

    public Product(int id, String description, float price) {
        this.id = id;
        this.description = description;
        this.price = price;
        //TODO COMPUTE TOTAL PRICE
        
       pvp=Tax.computeTotal(price, 15F);
        
    
        
        
    }

    
    public Product(int id, String description, float price, float pvp) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.pvp = pvp;
    }

    
    
    
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", description=" + description + ", price=" + price + ", pvp=" + pvp + '}';
    }

    
    
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public float getPvp() {
        return pvp;
    }
    float pvp;
    
    
    
    
}
