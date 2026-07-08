package ec.edu.espe.mazeapplication.model;

/**
 *
 * @author Joel Sanchez
 */
public class Wall {

    private boolean northWall;
    private boolean southWall;
    private boolean eastWall;
    private boolean westWall;

    public Wall() {
        northWall = false;
        southWall = false;
        eastWall = false;
        westWall = false;
    }

    public Wall(boolean northWall, boolean southWall,
                boolean eastWall, boolean westWall) {

        this.northWall = northWall;
        this.southWall = southWall;
        this.eastWall = eastWall;
        this.westWall = westWall;
    }

    public boolean isNorthWall() {
        return northWall;
    }

    public void setNorthWall(boolean northWall) {
        this.northWall = northWall;
    }

    public boolean isSouthWall() {
        return southWall;
    }

    public void setSouthWall(boolean southWall) {
        this.southWall = southWall;
    }

    public boolean isEastWall() {
        return eastWall;
    }

    public void setEastWall(boolean eastWall) {
        this.eastWall = eastWall;
    }

    public boolean isWestWall() {
        return westWall;
    }

    public void setWestWall(boolean westWall) {
        this.westWall = westWall;
    }

}