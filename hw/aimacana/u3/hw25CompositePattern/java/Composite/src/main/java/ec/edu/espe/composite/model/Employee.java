package ec.edu.espe.composite.model;

public abstract class Employee {
    protected String name = "not assigned yet";
    protected String title = "not assigned yet";
    
    public String stateName() {
        return title + " " + name + "\n";
    }
}
