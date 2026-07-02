/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.products.model;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Watch extends Product {

    private String strapMaterial;
    private Battery battery;

    public Watch(int id, String name, float price, String strapMaterial, Battery battery) {
        super(id, name, price);
        this.strapMaterial = strapMaterial;
        this.battery = battery;
    }

    public String getStrapMaterial() {
        return strapMaterial;
    }

    public void setStrapMaterial(String strapMaterial) {
        this.strapMaterial = strapMaterial;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    @Override
    public void sell() {
        System.out.println("Watch sold successfully.");
    }

}
