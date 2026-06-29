/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oopconceptsfarm.model;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
import java.util.ArrayList;
import java.util.Date;

public class Pig extends FarmAnimal implements IMeatAnimal {

    private float idealWeight;
    private int penNumber;
    private float totalMeatProduced;

    public Pig(int id, String breed,
            Date bornOn,
            float weight,
            String healthStatus,
            float idealWeight,
            int penNumber) {

        super(id, breed, bornOn, weight, healthStatus);

        this.idealWeight = idealWeight;
        this.penNumber = penNumber;
        this.totalMeatProduced = 0;
    }
    public void addMeatProduction(float kilograms){
    totalMeatProduced += kilograms;
}

public float getTotalMeatProduced(){
    return totalMeatProduced;
}

    @Override
    public ArrayList<Cut> cut() {

        ArrayList<Cut> cuts = new ArrayList<>();

        float meatYield;

        if (weight >= idealWeight) {

            meatYield = weight * 0.70f;

            cuts.add(new Cut(
                    1,
                    "Premium Pork",
                    "Premium Process",
                    meatYield));

        } else {

            meatYield = weight * 0.55f;

            cuts.add(new Cut(
                    1,
                    "Commercial Pork",
                    "Commercial Process",
                    meatYield));

        }

        return cuts;
    }

    @Override
    public void sendToSlaughterHouse(
            SlaughterHouse slaughterHouse) {

        System.out.println(
                "Pig sent to "
                + slaughterHouse.getName());
    }
}
