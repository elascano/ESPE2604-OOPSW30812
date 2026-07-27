
package ec.edu.espe.strategypattern.model;

/**
 *
 * @author Alexander Tipantiza, CodeBreakers, @ESPE
 */

public class SortingContext {
    private SortingStrategy sortStrategy;

    public SortingContext() {}

    public SortingContext(SortingStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public int[] sort(int[] numbers) {
        return sortStrategy.sort(numbers);
    }

    public SortingStrategy getSortStrategy() {
        return sortStrategy;
    }

    public void setSortStrategy(SortingStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }
}