
package ec.edu.espe.classdiagram.model;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander Tipantiza < The_Softwarrios of Espeyour>
 */
public abstract class A {
    protected String name;
    protected List<A> subPartsA;

    public A(String name) {
        this.name = name;
        this.subPartsA = new ArrayList<>();
    }

    public abstract void displayBehavior();

    public void addSubPartA(A child) {
        if (child != null) {
            this.subPartsA.add(child);
        }
    }

    public String getName() {
        return name;
    }
}