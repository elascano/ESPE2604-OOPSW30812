package ec.edu.espe.oopconceptszoo.model;

import ec.edu.espe.oopconceptszoo.controller.IMeatAnimal;
import java.util.ArrayList;
import java.util.Date;

public class Pig extends FarmAnimal implements IMeatAnimal {
    float idealWeight;

    public Pig(int id, String breed, Date bornOn, float weight, float idealWeight) {
        super(id, breed, bornOn, weight);
        this.idealWeight = idealWeight;
    }

    public void sendToButcher() {
        System.out.println("Pig " + id + " sent to butcher.");
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts = new ArrayList<>();
        cuts.add(new Cut(1, "Pork Chop", "Standard Cut", 2.5f));
        cuts.add(new Cut(2, "Ribs", "Rib Extraction", 4.0f));
        return cuts;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterhouse) {
        System.out.println("Pig " + id + " sent to " + slaughterhouse.description);
    }

    public float getIdealWeight() { return idealWeight; }
}