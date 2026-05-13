package ec.edu.espe.chickenfarm.model;

public class Chicken {
    private int id;
    private String name;
    private String color;
    private int age;
    private boolean isMolting;

    public Chicken(int id, String name, String color, int age, boolean isMolting) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.age = age;
        this.isMolting = isMolting;
    }

    @Override
    public String toString() {
        return String.format("Chicken{id=%d, name=%s, color=%s, age=%d, isMolting=%b}", 
                id, name, color, age, isMolting);
    }
}
