
package ec.edu.espe.compositejava.model;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */

public abstract class Employee {

    protected String name;
    protected String title;

    public Employee(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public abstract void display();
}
