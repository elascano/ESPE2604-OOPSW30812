// Product.java
package ec.edu.espe.storesystem.model;

public class Product {

    private String name;
    private int id;
    private double price;
    private double weightPounds;

    public Product() {
    }

    public Product(String name, int id, double price, double weightPounds) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.weightPounds = weightPounds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeightPounds() {
        return weightPounds;
    }

    public void setWeightPounds(double weightPounds) {
        this.weightPounds = weightPounds;
    }

    public double getWeightKg() {
        return weightPounds * 0.453592;
    }
}