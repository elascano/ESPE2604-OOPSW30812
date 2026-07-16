
package ec.edu.espe.compositejava.model;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */

public class Clerk extends Employee {

    public Clerk(String name) {
        super(name, "Clerk");
    }

    @Override
    public void display() {
        System.out.println(title + ": " + name);
    }
}