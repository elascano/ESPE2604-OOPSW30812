package ec.edu.espe.composite.model;

/**
 *
 * @author Brandon Collahuazo,CodeBros,@ESPE
 */
public class Manager extends Supervisor {

    public Manager(String aName) {
        this();
        name = aName;
    }

    public Manager() {
        super();
        title = "Manager";
    }

    @Override
    public void stateName() {
        super.stateName();
    }
}
