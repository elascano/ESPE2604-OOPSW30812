package model;

public abstract class MealPreparation {
    public final void prepareMeal() {
        gatherIngredients();
        cook();
        plate();
        if (wantsGarnish()) {
            addGarnish();
        }
    }

    public void gatherIngredients() {
        System.out.println("Gathering ingredients");
    }

    public abstract void cook();

    public void plate() {
        System.out.println("Plating the dish");
    }

    public abstract void addGarnish();

    public boolean wantsGarnish() {
        return true;
    }
}
