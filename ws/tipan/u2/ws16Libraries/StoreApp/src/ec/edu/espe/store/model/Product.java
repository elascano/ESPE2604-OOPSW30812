/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.store.model;

import utils.Tax;

/**
 *
 * @author Ronald Tipan <The_Softwarrios at ESPE>
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

        pvp = Tax.computeTotal(price, 15F);
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description=" + description +
                ", price=" + price +
                ", pvp=" + pvp +
                '}';
    }
}