package ec.edu.espe.composite.model;

public class Teller extends Employee {
    public Teller() {
        title = "Teller";
    }

    public Teller(String aName) {
        this();
        name = aName;
    }
    
    @Override
    public String stateName() {
        return super.stateName();
    }
}
