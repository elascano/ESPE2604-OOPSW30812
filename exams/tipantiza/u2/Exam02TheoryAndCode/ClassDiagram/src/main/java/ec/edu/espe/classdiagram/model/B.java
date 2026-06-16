
package ec.edu.espe.classdiagram.model;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander Tipantiza < The_Softwarrios of Espeyour>
 */
public class B extends A {
    private List<H> associatedH; 

    public B(String name) {
        super(name);
        this.associatedH = new ArrayList<>();
    }

    @Override
    public void displayBehavior() {
        System.out.println("I am Object B ('" + name + "'), inherited from A. Managing structural associations with H.");
    }

    public void addAssociationH(H hObj) {
        if (hObj != null) {
            associatedH.add(hObj);
        }
    }
}
