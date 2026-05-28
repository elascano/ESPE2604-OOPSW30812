package ec.edu.espe.store.model;

import utils.Tax;

/**
 *
 * @author Edison Lascano, Object Masters, @ESPE
 */
public class Product {

    private int id;
    private String description;
    private float price;
    private float pvp;

    public Product(int id, String description, float price) {
        this.id = id;
        this.description = description;
        this.price = price;

        //TODO compute total price
        pvp = Tax.computeTotal(price, 15F);
    }

    public Product(int id, String description, float price, float pvp) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.pvp = pvp;
    }

    @Override
    public String toString() {
        return "Product\n{" + "id=" + id + "\n description=" + description + "\n price=" + price + "\n pvp=" + pvp + '}';
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

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the pvp
     */
    public float getPvp() {
        return pvp;
    }

    /**
     * @param pvp the pvp to set
     */
    public void setPvp(float pvp) {
        this.pvp = pvp;
    }

}
