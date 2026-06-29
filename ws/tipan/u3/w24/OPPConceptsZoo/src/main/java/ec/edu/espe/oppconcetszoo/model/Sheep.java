package ec.edu.espe.oppconcetszoo.model;

import ec.edu.espe.oppconcetszoo.controller.IMeatAnimal;
import java.util.ArrayList;

public class Sheep extends FarmAnimal implements IMeatAnimal {

    public Sheep(int id, String breed, Date bornOn, float weight) {
        super(id, breed, bornOn, weight);
    }

    @Override
    public void born() {
        System.out.println("A lamb was born.");
    }

    @Override
    public ArrayList<Cut> cut() {
        return new ArrayList<>();
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        System.out.println("Sheep sent to slaughterhouse.");
    }

}