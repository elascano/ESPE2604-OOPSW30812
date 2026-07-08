package ec.edu.espe.mazeapplication.model;

/**
 * Exit Door
 * @author Joel Sanchez
 */
public class ExitDoor extends Door {

    public ExitDoor() {
        super();
        openDoor();        
    }

    @Override
    public String toString() {
        return "Exit Door";
    }

}