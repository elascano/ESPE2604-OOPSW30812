package ec.edu.espe.oopconceptszoo.model;

public class Cut {
    private String name;
    private float weight;
    
    public Cut(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }
    
    public String getName() { return name; }
    public float getWeight() { return weight; }
}
