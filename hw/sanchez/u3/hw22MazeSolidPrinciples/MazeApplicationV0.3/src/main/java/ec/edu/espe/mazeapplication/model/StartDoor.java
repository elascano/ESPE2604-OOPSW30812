package ec.edu.espe.mazeapplication.model;

/**
 * Start Door
 * @author Joel Sanchez
 */
public class StartDoor extends Door {

    public StartDoor() {
        super();
        openDoor();        
    }

    @Override
    public String toString() {
        return "Start Door";
    }

}
