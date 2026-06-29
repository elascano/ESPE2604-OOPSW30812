package ec.edu.espe.oopconceptszoo.model;

import ec.edu.espe.oopconceptszoo.controller.IMeatAnimal;
import java.util.ArrayList;
import java.util.Date;

public class Cow extends FarmAnimal implements IMeatAnimal {
    boolean isProducingMilk;
    float milk;

    public Cow(int id, String breed, Date bornOn, float weight, boolean isProducingMilk, float milk) {
        super(id, breed, bornOn, weight);
        this.isProducingMilk = isProducingMilk;
        this.milk = milk;
    }

    public boolean isProducingMilk() {
        return isProducingMilk;
    }

    public float milk() {
        return milk;
    }

    @Override
    public int getAgeInMonths() {
        return super.getAgeInMonths();
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts = new ArrayList<>();
        cuts.add(new Cut(10, "T-Bone", "Rib Section", 5.5f));
        cuts.add(new Cut(11, "Ribeye", "Loin Section", 3.8f));
        return cuts;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterhouse) {
        System.out.println("Cow " + id + " sent to " + slaughterhouse.description);
    }
}