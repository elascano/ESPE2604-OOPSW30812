
package ec.edu.espe.compositejava.model;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */

public class Teller extends Employee {

    public Teller(String name) {
        super(name, "Teller");
    }

    @Override
    public void display() {
        System.out.println(title + ": " + name);
    }
}
