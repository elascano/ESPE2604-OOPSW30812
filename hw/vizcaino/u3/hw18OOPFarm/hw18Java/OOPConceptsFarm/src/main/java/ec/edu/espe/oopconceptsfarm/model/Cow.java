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

public class Cow extends FarmAnimal implements IMeatAnimal {

    private boolean isProducingMilk;
    private float dailyMilkYield;
    private float totalMilkProduced;

    public Cow(int id,
            String breed,
            Date bornOn,
            float weight,
            String healthStatus,
            boolean isProducingMilk,
            float dailyMilkYield) {

        super(id, breed, bornOn, weight, healthStatus);

        this.isProducingMilk = isProducingMilk;
        this.dailyMilkYield = dailyMilkYield;
        this.totalMilkProduced = 0;
    }

    public void milk() {

        if (isProducingMilk) {
            System.out.println(
                    "Milk produced: "
                    + dailyMilkYield + " liters");
        }
    }
    public void addMilkProduction(float liters){
    totalMilkProduced += liters;
}

public float getTotalMilkProduced(){
    return totalMilkProduced;
}

    @Override
    public ArrayList<Cut> cut() {

        ArrayList<Cut> cuts = new ArrayList<>();

        cuts.add(
                new Cut(
                        1,
                        "Beef",
                        "Standard Beef Process",
                        weight * 0.65f));

        return cuts;
    }

    @Override
    public void sendToSlaughterHouse(
            SlaughterHouse slaughterHouse) {

        System.out.println(
                "Cow sent to "
                + slaughterHouse.getName());
    }
}
