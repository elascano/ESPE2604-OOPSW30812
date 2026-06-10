package ec.edu.espe.educativesoftware.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Teacher extends User {

    private String profession;
    private List<Course> courses;

    public Teacher() {
    }

    public Teacher(String profession, String id, String name, String email, String password) {
        super(id, name, email, password, Role.TEACHER);
        this.profession = profession;
        this.courses = new ArrayList<>();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
