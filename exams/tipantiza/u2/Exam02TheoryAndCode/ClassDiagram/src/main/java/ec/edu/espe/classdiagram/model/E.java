
package ec.edu.espe.classdiagram.model;

/**
 *
 * @author Alexander Tipantiza < The_Softwarrios of Espeyour>
 */
public class E {
    private String id;

    public E(String id) {
        this.id = id;
    }

    public void showE() {
        System.out.println("    Component E [ID: " + id + "]");
    }
}