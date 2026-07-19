package ec.edu.espe.composite.model;

public class Manager extends Supervisor {
    public Manager() {
        super();
        title = "Manager";
    }

    public Manager(String aName) {
        this();
        name = aName;
    }
    
    @Override
    public String stateName() {
        return super.stateName();
    }
}
