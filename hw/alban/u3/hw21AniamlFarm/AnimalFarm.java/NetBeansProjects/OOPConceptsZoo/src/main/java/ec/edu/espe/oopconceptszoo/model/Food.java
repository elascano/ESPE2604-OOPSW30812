package ec.edu.espe.oopconceptszoo.model;

public class Food {
    int id;
    String description;

    public Food(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() { return id; }
    public String getDescription() { return description; }
}