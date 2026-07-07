package ec.edu.espe.mazesystem.model; 

public class Door {
    private boolean isOpen;
    private boolean isExterior;

    public Door() {
        this.isOpen = false;
        this.isExterior = false;
    }

    public Door(boolean isExterior) {
        this.isOpen = false;
        this.isExterior = isExterior;
    }

    public void open() {
        this.isOpen = true;
    }

    public void close() {
        this.isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public boolean isExterior() {
        return isExterior;
    }

    public void setExterior(boolean exterior) {
        isExterior = exterior;
    }
}