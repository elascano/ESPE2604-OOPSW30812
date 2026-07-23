package ec.edu.espe.oppconcetszoo.model;

import ec.edu.espe.oppconcetszoo.controller.IMeatAnimal;
import java.util.ArrayList;

public class Pig extends FarmAnimal implements IMeatAnimal {

    public Pig(int id, String breed, Date bornOn, float weight) {
        super(id, breed, bornOn, weight);
    }

    @Override
    public void born() {
        System.out.println("A piglet was born.");
    }

    @Override
    public ArrayList<Cut> cut() {
        return new ArrayList<>();
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        System.out.println("Pig sent to slaughterhouse.");
    }

}