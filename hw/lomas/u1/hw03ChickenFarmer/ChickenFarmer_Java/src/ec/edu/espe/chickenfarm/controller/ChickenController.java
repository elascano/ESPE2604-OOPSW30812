package ec.edu.espe.chickenfarm.controller;
import ec.edu.espe.chickenfarm.model.Chicken;
import java.util.ArrayList;

public class ChickenController {
    private ArrayList<Chicken> chickens = new ArrayList<>();

    public Chicken createChicken(int id, String name, String color, int age, boolean isMolting) {
        Chicken newChicken = new Chicken(id, name, color, age, isMolting);
        chickens.add(newChicken);
        return newChicken;
    }
}
