package ec.edu.espe.mazeapplication.model;

/**
 *
 * @author Joel Sanchez
 */
public class Maze {

    private int rows;
    private int columns;
    private Room[][] rooms;
    private Path path;

    public Maze(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        rooms = new Room[rows][columns];
        path = new Path();
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Room[][] getRooms() {
        return rooms;
    }

    public void setRooms(Room[][] rooms) {
        this.rooms = rooms;
    }

    public Room getRoom(int row, int column) {
        return rooms[row][column];
    }

    public void setRoom(int row, int column, Room room) {
        rooms[row][column] = room;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
}