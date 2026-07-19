package ec.edu.espe.composite.model;

public class President extends Supervisor {
    private static President president = new President();
    
    private President() {
        super();
        title = "President";
    }

    private President(String aName) {
        this();
        name = aName;
    }
    
    @Override
    public String stateName() {
        return super.stateName();
    }
    
    public static President getPresident(String aName) {
        president.name = aName;
        return President.president;
    }
}
