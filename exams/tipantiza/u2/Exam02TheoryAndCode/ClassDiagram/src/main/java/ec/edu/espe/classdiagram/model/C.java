
package ec.edu.espe.classdiagram.model;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Alexander Tipantiza < The_Softwarrios of Espeyour>
 */
public class C extends A {
    private List<E> aggregatedE; 

    public C(String name) {
        super(name);
        this.aggregatedE = new ArrayList<>();
    }

    @Override
    public void displayBehavior() {
        System.out.println("I am Object C ('" + name + "'), inherited from A. Aggregating E objects (Max 3).");
    }

    public boolean addAggregationE(E eObj) {
        if (aggregatedE.size() < 3 && eObj != null) {
            aggregatedE.add(eObj);
            return true;
        }
        return false;
    }

    public void showAggregatedElements() {
        for (E e : aggregatedE) {
            e.showE();
        }
    }
}
