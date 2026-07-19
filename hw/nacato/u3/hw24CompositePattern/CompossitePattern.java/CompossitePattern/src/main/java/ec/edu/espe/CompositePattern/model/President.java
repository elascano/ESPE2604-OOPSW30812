
package ec.edu.espe.CompositePattern.model;

/**
 *
 * @author Angie Ñacato, Error 404, @ESPE
 */
public class President extends Supervisor {
    private static President president = new President();

    private President(String aName) {
        this();
        name = aName;
    }

    private President() {
        super();
        title = "President";
    }

    @Override
    public void stateName() {
        super.stateName();
    }

    public static President getPresident(String aName) {
        president.name = aName;
        return President.president;
    }
}