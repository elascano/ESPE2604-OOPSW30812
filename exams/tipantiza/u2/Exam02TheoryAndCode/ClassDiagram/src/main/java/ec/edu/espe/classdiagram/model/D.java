
package ec.edu.espe.classdiagram.model;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Alexander Tipantiza < The_Softwarrios of Espeyour>
 */
public class D extends A {
    private List<E> aggregatedE; 
    private List<F> composedF;   

    public D(String name) {
        super(name);
        this.aggregatedE = new ArrayList<>();
        this.composedF = new ArrayList<>();
    }

    @Override
    public void displayBehavior() {
        System.out.println("I am Object D ('" + name + "'), inherited from A. Handling Composition with F and Aggregation with E.");
    }

    public boolean addAggregationE(E eObj) {
        if (aggregatedE.size() < 5 && eObj != null) {
            aggregatedE.add(eObj);
            return true;
        }
        return false;
    }

    public void createAndComposeF(String type) {
        this.composedF.add(new F(type));
    }

    public void showDetails() {
        System.out.println("  -> Aggregated elements from E (External parts):");
        for (E e : aggregatedE) e.showE();
        System.out.println("  -> Composed elements from F (Strictly owned life cycle):");
        for (F f : composedF) f.showF();
    }
}
