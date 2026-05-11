package ec.edu.espe.educativeapp.model;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */

public class Teacher {

    private int id;
    private String name;
    private String career;

    public Teacher(int id, String name, String career) {
        this.id = id;
        this.name = name;
        this.career = career;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCareer() {
        return career;
    }

    @Override
    public String toString() {
        return "Teacher{"
                + "id=" + id
                + ", name=" + name
                + ", career=" + career
                + '}';
    }
}