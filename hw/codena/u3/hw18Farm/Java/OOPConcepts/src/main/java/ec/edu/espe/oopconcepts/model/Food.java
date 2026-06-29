package ec.edu.espe.oopconcepts.model;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Food {

    private int id;
    private String typeOfFood;

    public Food(int id, String description) {
        this.id = id;
        this.typeOfFood = description;
    }

    @Override
    public String toString() {
        return id + " - " + typeOfFood;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

}
