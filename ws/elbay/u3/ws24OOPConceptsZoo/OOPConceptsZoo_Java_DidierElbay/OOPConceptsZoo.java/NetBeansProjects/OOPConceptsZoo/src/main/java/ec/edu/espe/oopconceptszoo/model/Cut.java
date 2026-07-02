package ec.edu.espe.oopconceptszoo.model;

/**
 * Represents a meat cut produced from a slaughtered animal.
 *
 * @author Didier Elbay
 */
public class Cut {

    private int id;
    private String description;
    private String procedure;
    private float weight;

    public Cut(int id, String description, String procedure, float weight) {
        this.id = id;
        this.description = description;
        this.procedure = procedure;
        this.weight = weight;
    }

    public int getId()             { return id; }
    public String getDescription() { return description; }
    public String getProcedure()   { return procedure; }
    public float getWeight()       { return weight; }
}
