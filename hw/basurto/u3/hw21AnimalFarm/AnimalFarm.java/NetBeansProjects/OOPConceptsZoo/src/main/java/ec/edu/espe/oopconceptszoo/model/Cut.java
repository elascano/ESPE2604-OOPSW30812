package ec.edu.espe.oopconceptszoo.model;

public class Cut {
    int id;
    String description;
    String procedure;
    float weight;

    public Cut(int id, String description, String procedure, float weight) {
        this.id = id;
        this.description = description;
        this.procedure = procedure;
        this.weight = weight;
    }

    public int getId() { return id; }
    public String getDescription() { return description; }
    public String getProcedure() { return procedure; }
    public float getWeight() { return weight; }
}