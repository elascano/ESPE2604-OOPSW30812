package ec.edu.espe.composite.model;

public class Clerk extends Employee {
    public Clerk() {
        title = "Clerk";
    }

    public Clerk(String aName) {
        this();
        name = aName;
    }
    
    @Override
    public String stateName() {
        return super.stateName();
    }
}
