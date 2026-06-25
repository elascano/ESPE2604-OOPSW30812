/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oopconcepts.model;

import java.util.Date;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Sheep extends FarmAnimal{
    private Date lastSheering;

    public Sheep(Date lastSheering, int id, String breed, Date bornOnDate, float weight) {
        super(id, breed, bornOnDate, weight);
        this.lastSheering = lastSheering;
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding a sheep with --> " + food);
    }

    public Date getLastSheering() {
        return lastSheering;
    }

    public void setLastSheering(Date lastSheering) {
        this.lastSheering = lastSheering;
    }
    
    
}
