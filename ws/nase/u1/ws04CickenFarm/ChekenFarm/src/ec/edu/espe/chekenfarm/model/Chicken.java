package ec.edu.espe.chekenfarm.model;

public class Chicken {
    private String name;
    private String color;
    private int age;
    private boolean isMolting;

    public void operation() {
    }

    private void cluck() {
    }

    private void wander() {
    }

    private void eat() {
    }

    private void drink() {
    }

    public Poop oop() {
        return new Poop();
    }

    public Egg layAnEgg() {
        return new Egg();
    }
}