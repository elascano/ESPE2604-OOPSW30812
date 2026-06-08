/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.espe.ec.WorkshopAdrianVizcaino.model;
/**
 *
 * @author Adrian Vizcaino <The-Softwarrios at ESPE>
 */


public class Product {

    private int id;
    private String name;
    private int quantity;

    public Product(int id, String name, int quantity) {

        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {

        return id;
    }

    public int getQuantity() {

        return quantity;
    }

    @Override
    public String toString() {

        return "ID: " + id +
               " | Name: " + name +
               " | Quantity: " + quantity;
    }
}