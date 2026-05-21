package ec.edu.espe.store.model;

import utils.Tax;

/**
 *
 * @author Collahuazo Brandon, CodeBros , @ESPE
 */
public class Product {
    private int id;
    private String descripcion;
    private float price;
    private float pvp;

    public Product(int id, String descripcion, float price) {
        this.id = id;
        this.descripcion = descripcion;
        this.price = price;
        
        //TODO compute total price
        pvp = Tax.computeTotal(price, 15F);
    }  
    //sobre carga de funciones polymorphism
    
    public Product(int id, String descripcion, float price, float pvp) {
        this.id = id;
        this.descripcion = descripcion;
        this.price = price;
        this.pvp = pvp;
    }

    
    @Override
    public String toString() {
        return "Product\n{" + "id=" + id + "descripcion=" + descripcion + " price=" + price + "pvp=" + pvp + '}';
    }

    /**
     * @return the id
     */
    private int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    private void setId(int id) {
        this.id = id;
    }

    /**
     * @return the descripcion
     */
    private String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    private void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the price
     */
    private float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    private void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the pvp
     */
    private float getPvp() {
        return pvp;
    }

    /**
     * @param pvp the pvp to set
     */
    private void setPvp(float pvp) {
        this.pvp = pvp;
    }
    
    
}
