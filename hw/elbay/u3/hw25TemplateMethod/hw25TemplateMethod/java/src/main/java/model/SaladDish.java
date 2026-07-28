package model;

public class SaladDish extends MealPreparation {
    @Override
    public void cook() {
        System.out.println("Chopping vegetables and mixing dressing");
    }

    @Override
    public void addGarnish() {
        System.out.println("Adding croutons and sesame seeds");
    }
}
