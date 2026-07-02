
package ec.edu.espe.animalfarmsystem.model;

/**
 *
 * @author LABS-ESPE
 */
public class Product {
    
    private int id; 
    private String description; 
    String unit;
    float quantity;

    public Product(int id, String description, String unit, float quantity) {
        this.id = id;
        this.description = description;
        this.unit = unit;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", description=" + description + ", unit=" + unit + ", quantity=" + quantity + '}';
    }
    



    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    
    
    
    
}
