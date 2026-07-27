package model;

public class PastaDish extends MealPreparation {
    @Override
    public void cook() {
        System.out.println("Boiling pasta and simmering sauce");
    }

    @Override
    public void addGarnish() {
        System.out.println("Adding grated parmesan and basil");
    }
}
