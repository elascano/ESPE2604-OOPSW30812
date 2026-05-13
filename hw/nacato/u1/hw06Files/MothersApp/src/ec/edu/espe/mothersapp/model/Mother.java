package ec.edu.espe.mothersapp.model;
import java.util.ArrayList;
/**
 *
 * @author Angie Nacato, Error 404, @ESPE
 */
public class Mother {
    private String name;
    private ArrayList<Baby> babies;

    public Mother() {
        this.babies = new ArrayList<>();
    }

    public Mother(String name) {
        this.name = name;
        this.babies = new ArrayList<>();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ArrayList<Baby> getBabies() { return babies; }
    public void setBabies(ArrayList<Baby> babies) { this.babies = babies; }
}