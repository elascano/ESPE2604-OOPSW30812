package ec.edu.espe.composite.model;

/**
 *
 * @author Brandon Collahuazo,CodeBros,@ESPE
 */
public abstract class Employee {

    public String name = "not assigned yet";
    public String title = "not assigned yet";

    public void stateName() {
        System.out.println(title + " " + name);
    }
}
