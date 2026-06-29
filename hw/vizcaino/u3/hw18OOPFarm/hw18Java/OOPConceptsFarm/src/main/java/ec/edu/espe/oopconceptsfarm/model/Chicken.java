/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oopconceptsfarm.model;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
import java.util.Date;

public class Chicken extends FarmAnimal {

    private boolean isMolting;
    private int numberOfEggsPerWeek;
    private String eggColor;
    private int totalEggsProduced;

    public Chicken(int id,
            String breed,
            Date bornOn,
            float weight,
            String healthStatus,
            boolean isMolting,
            int numberOfEggsPerWeek,
            String eggColor) {

        super(id, breed, bornOn, weight, healthStatus);

        this.isMolting = isMolting;
        this.numberOfEggsPerWeek = numberOfEggsPerWeek;
        this.eggColor = eggColor;
        this.totalEggsProduced = 0;
    }

    public void layAnEgg() {
        System.out.println("Egg laid");
    }
    public int getTotalEggsProduced() {
    return totalEggsProduced;
}

   public void setTotalEggsProduced(int totalEggsProduced) {
    this.totalEggsProduced = totalEggsProduced;
}
   public int getNumberOfEggsPerWeek() {
    return numberOfEggsPerWeek;
}

public String getEggColor() {
    return eggColor;
}
}
