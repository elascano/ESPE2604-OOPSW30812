package ec.edu.espe.oppconcetszoo.model;

public class Chicken extends FarmAnimal {

    public Chicken(int id, String breed, Date bornOn, float weight) {
        super(id, breed, bornOn, weight);
    }

    @Override
    public void born() {
        System.out.println("A chick was born.");
    }

}