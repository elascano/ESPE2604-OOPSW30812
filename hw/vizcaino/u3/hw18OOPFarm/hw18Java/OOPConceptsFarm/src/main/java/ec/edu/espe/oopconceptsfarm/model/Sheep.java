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

public class Sheep extends FarmAnimal {

    private Date lastSheering;
    private String woolQuality;
    private float totalWoolProduced;

    public Sheep(int id,
            String breed,
            Date bornOn,
            float weight,
            String healthStatus,
            Date lastSheering,
            String woolQuality) {

        super(id, breed, bornOn, weight, healthStatus);

        this.lastSheering = lastSheering;
        this.woolQuality = woolQuality;
        this.totalWoolProduced = 0;
    }

    public void shear() {
        lastSheering = new Date();
    }
    public void addWoolProduction(float kilograms){
    totalWoolProduced += kilograms;
}

public float getTotalWoolProduced(){
    return totalWoolProduced;
}
}
