/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.products.model;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Battery {

    private int capacity;
    private boolean rechargeable;

    public Battery(int capacity, boolean rechargeable) {
        this.capacity = capacity;
        this.rechargeable = rechargeable;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isRechargeable() {
        return rechargeable;
    }

    public void setRechargeable(boolean rechargeable) {
        this.rechargeable = rechargeable;
    }

    @Override
    public String toString() {
        return "Battery{" +
                "capacity=" + capacity +
                ", rechargeable=" + rechargeable +
                '}';
    }

}