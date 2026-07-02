package ec.edu.espe.oopconceptszoo.model;

/**
 * Represents a type of food given to farm animals.
 *
 * @author Didier Elbay
 */
public class Food {

    private int id;
    private String description;

    public Food(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId()             { return id; }
    public String getDescription() { return description; }
}
