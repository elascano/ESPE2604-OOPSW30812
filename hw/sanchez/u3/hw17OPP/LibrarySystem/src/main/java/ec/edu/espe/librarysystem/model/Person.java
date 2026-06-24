package ec.edu.espe.librarysystem.model;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public abstract class Person {

    protected String id;
    protected String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract String getInfo();
}