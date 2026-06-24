package ec.edu.espe.librarysystem.model;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class Member extends Person {

    private String email;

    public Member(String id, String name, String email) {
        super(id, name);
        this.email = email;
    }

    @Override
    public String getInfo() {
        return name + " - " + email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
