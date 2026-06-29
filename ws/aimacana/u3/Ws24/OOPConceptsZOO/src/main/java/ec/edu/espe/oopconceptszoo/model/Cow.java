package ec.edu.espe.oopconceptszoo.model;

import ec.edu.espe.oopconceptszoo.controller.IMeatAnimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Cow extends FarmAnimal implements IMeatAnimal {

    private boolean isProducingMilk;

    public Cow(int id, String breed, LocalDate bornOn, float weight, boolean isProducingMilk) {
        super(id, breed, bornOn, weight);
        this.isProducingMilk = isProducingMilk;
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding cow (" + getBreed() + ") with " + food.getDescription());
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts = new ArrayList<>();
        cuts.add(new Cut("Ribeye", 2.5f));
        cuts.add(new Cut("T-Bone", 3.0f));
        return cuts;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        slaughterHouse.processAnimal(this);
    }
    
    public float milk() {
        return isProducingMilk ? 10.5f : 0.0f; // Mock value
    }
    
    public boolean getIsProducingMilk() { return isProducingMilk; }
    public void setIsProducingMilk(boolean isProducingMilk) { this.isProducingMilk = isProducingMilk; }
}
