/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.model;

/**
 *
 * @author Cristian
 */
public class CellPhone extends Device{
    private String imei;

    private Battery battery;

    private Screen screen;

    private SIMCard simCard;

    public CellPhone(String brand,
                     String model,
                     String imei,
                     Battery battery,
                     Screen screen,
                     SIMCard simCard) {

        super(brand, model);

        this.imei = imei;
        this.battery = battery;
        this.screen = screen;
        this.simCard = simCard;
    }

    @Override
    public void turnOn() {
        System.out.println("Phone ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Phone OFF");
    }

    public void makeCall(String number) {
        System.out.println("Calling " + number);
    }

    public void showInfo() {

        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("IMEI: " + getImei());
        System.out.println("Battery: " +
                getBattery().getCapacity() + " mAh");

        System.out.println("Screen: " +
                getScreen().getSize() + "\"");

        System.out.println("Operator: " +
                getSimCard().getOperator());
    }

    /**
     * @return the imei
     */
    public String getImei() {
        return imei;
    }

    /**
     * @return the battery
     */
    public Battery getBattery() {
        return battery;
    }

    /**
     * @return the screen
     */
    public Screen getScreen() {
        return screen;
    }

    /**
     * @return the simCard
     */
    public SIMCard getSimCard() {
        return simCard;
    }
}
