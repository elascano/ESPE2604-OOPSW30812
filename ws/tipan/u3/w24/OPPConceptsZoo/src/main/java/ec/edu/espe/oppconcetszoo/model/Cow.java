package ec.edu.espe.oppconcetszoo.model;

import ec.edu.espe.oppconcetszoo.controller.IMeatAnimal;
import java.util.ArrayList;

public class Cow extends FarmAnimal implements IMeatAnimal {

    public Cow(int id, String breed, Date bornOn, float weight) {
        super(id, breed, bornOn, weight);
    }

    @Override
    public void born() {
        System.out.println("A calf was born.");
    }

    @Override
    public void feed(Food food) {
        super.feed(food);
    }

    @Override
    public ArrayList<Cut> cut() {
        return new ArrayList<>();
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        System.out.println("Cow sent to slaughterhouse.");
    }

}