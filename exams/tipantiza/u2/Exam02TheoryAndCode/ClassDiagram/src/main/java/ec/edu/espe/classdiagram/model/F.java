
package ec.edu.espe.classdiagram.model;

/**
 *
 * @author Alexander Tipantiza < The_Softwarrios of Espeyour>
 */
public class F {
    private String type;

    public F(String type) {
        this.type = type;
    }

    public void showF() {
        System.out.println("    Internal Part F [Type: " + type + "]");
    }
}