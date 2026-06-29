package ec.edu.espe.oopconceptszoo.model;

import ec.edu.espe.oopconceptszoo.controller.IMeatAnimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Sheep extends FarmAnimal implements IMeatAnimal {

    private LocalDate lastSheered;

    public Sheep(int id, String breed, LocalDate bornOn, float weight, LocalDate lastSheered) {
        super(id, breed, bornOn, weight);
        this.lastSheered = lastSheered;
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding sheep (" + getBreed() + ") with " + food.getDescription());
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts = new ArrayList<>();
        cuts.add(new Cut("Lamb Chops", 1.0f));
        cuts.add(new Cut("Leg of Lamb", 2.5f));
        return cuts;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        slaughterHouse.processAnimal(this);
    }

    public LocalDate getLastSheered() { return lastSheered; }
    public void setLastSheered(LocalDate lastSheered) { this.lastSheered = lastSheered; }
}
