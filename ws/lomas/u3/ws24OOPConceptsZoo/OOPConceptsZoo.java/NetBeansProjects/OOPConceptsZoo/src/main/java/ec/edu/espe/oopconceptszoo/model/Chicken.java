package ec.edu.espe.oopconceptszoo.model;

import java.util.Date;

public class Chicken extends FarmAnimal {
    boolean isMolting;
    int numberOfEggsPerWeek;

    public Chicken(int id, String breed, Date bornOn, float weight, boolean isMolting, int numberOfEggsPerWeek) {
        super(id, breed, bornOn, weight);
        this.isMolting = isMolting;
        this.numberOfEggsPerWeek = numberOfEggsPerWeek;
    }

    public void layAnEgg() {
        System.out.println("Chicken " + id + " laid an egg.");
    }

    public void operation() {
        System.out.println("Chicken operation executed.");
    }

    public boolean isMolting() { return isMolting; }
    public int getNumberOfEggsPerWeek() { return numberOfEggsPerWeek; }
}