package ec.edu.espe.oopconceptszoo.model;

import ec.edu.espe.oopconceptszoo.controller.IMeatAnimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Pig extends FarmAnimal implements IMeatAnimal {

    public Pig(int id, String breed, LocalDate bornOn, float weight) {
        super(id, breed, bornOn, weight);
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding pig (" + getBreed() + ") with " + food.getDescription());
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts = new ArrayList<>();
        cuts.add(new Cut("Pork Chops", 1.5f));
        cuts.add(new Cut("Bacon", 2.0f));
        return cuts;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        slaughterHouse.processAnimal(this);
    }
}
