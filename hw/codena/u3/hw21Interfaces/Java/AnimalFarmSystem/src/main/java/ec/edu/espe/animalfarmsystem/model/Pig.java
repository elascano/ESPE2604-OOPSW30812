/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmsystem.model;

import ec.edu.espe.animalfarmsystem.controller.IMeatAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author LABS-ESPE
 */
public class Pig extends FarmAnimal implements IMeatAnimal {

    private float idealWeight;

    public Pig(float idealWeight, int id, String breed, Date bornOnDate, float weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cuts) {
        super(id, breed, bornOnDate, weight, slaughterHouse, product, cuts);
        this.idealWeight = idealWeight;
    }

    @Override
    public String toString() {
        return "Pig{" + "idealWeight=" + idealWeight + '}';
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding the PIG with food --> " + food + "in a bowl and water");
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts = new ArrayList<>();

        if (slaughterHouse.getName() == null) {
            System.out.println("First send Pig to slaughterHouse");

        } else {

            cuts.add(new Cut(1, "Ham", "Pig", 20));
            cuts.add(new Cut(2, "Loin", "Pig", 16));
            cuts.add(new Cut(3, "Belly", "Pig", 16.5F));
            cuts.add(new Cut(4, "Feet", "Pig", 5));

            System.out.println("Pig has been cut: ");

            for (Cut cut : cuts) {
                System.out.println(cut.getDescription());

            }
        }

        return cuts;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {

        if (weight >= idealWeight) {
            this.slaughterHouse = slaughterHouse;
            System.out.println("Pig has been sent to SlaughterHouse " + slaughterHouse.getName());
        } else {
            System.out.println("Pig has not reached the ideal weight, it was not sent to slaughterhouse");
        }
    }

    /**
     * @return the idealWeight
     */
    public float getIdealWeight() {
        return idealWeight;
    }

    /**
     * @param idealWeight the idealWeight to set
     */
    public void setIdealWeight(float idealWeight) {
        this.idealWeight = idealWeight;
    }
}
