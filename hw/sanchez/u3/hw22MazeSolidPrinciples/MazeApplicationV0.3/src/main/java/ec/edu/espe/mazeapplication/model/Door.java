package ec.edu.espe.mazeapplication.model;

/**
 * 
 * @author Joel Sanchez
 */
public abstract class Door {

    protected boolean open;

    public Door() {
        open = false;
    }

    public boolean isOpen() {
        return open;
    }

    public void openDoor() {
        open = true;
    }

    public void closeDoor() {
        open = false;
    }

    @Override
    public String toString() {
        return open ? "Open Door" : "Closed Door";
    }
}