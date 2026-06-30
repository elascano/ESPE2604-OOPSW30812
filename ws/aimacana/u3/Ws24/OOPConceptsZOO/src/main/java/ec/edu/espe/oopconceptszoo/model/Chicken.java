package ec.edu.espe.oopconceptszoo.model;

import ec.edu.espe.oopconceptszoo.controller.IMeatAnimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Chicken extends FarmAnimal implements IMeatAnimal {

    private boolean isMolting;

    public Chicken(int id, String breed, LocalDate bornOn, float weight, boolean isMolting) {
        super(id, breed, bornOn, weight);
        this.isMolting = isMolting;
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding chicken (" + getBreed() + ") with " + food.getDescription());
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts = new ArrayList<>();
        cuts.add(new Cut("Breast", 0.5f));
        cuts.add(new Cut("Wings", 0.2f));
        return cuts;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        slaughterHouse.processAnimal(this);
    }

    public boolean getIsMolting() { return isMolting; }
    public void setIsMolting(boolean isMolting) { this.isMolting = isMolting; }
}
