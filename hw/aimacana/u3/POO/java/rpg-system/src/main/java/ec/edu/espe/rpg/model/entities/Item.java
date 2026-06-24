package ec.edu.espe.rpg.model.entities;

public abstract class Item {
    private String id;
    private String name;
    private double weight;
    private String description;
    private double baseValue;

    public Item(String id, String name, double weight, String description, double baseValue) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.description = description;
        this.baseValue = baseValue;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getBaseValue() { return baseValue; }
    public void setBaseValue(double baseValue) { this.baseValue = baseValue; }
}
