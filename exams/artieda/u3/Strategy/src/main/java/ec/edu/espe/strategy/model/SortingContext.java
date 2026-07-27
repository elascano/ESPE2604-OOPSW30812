package ec.edu.espe.strategy.model;

public class SortingContext {
    private SortingStrategy sortingStrategy;

    public SortingStrategy setSortStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
        return this.sortingStrategy;
    }

    public SortingStrategy getSortStrategy() {
        return this.sortingStrategy;
    }

    public SortingStrategy setSortStrategyBasedOnSize(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("The number of elements must be greater than 1 (minimum size: 2).");
        }
        if (size >= 2 && size <= 6) {
            this.sortingStrategy = new BubbleSort();
        } else if (size >= 7 && size <= 10) {
            this.sortingStrategy = new InsertionSort();
        } else {
            this.sortingStrategy = new QuickSort();
        }
        return this.sortingStrategy;
    }

    public int[] sort(int[] data) {
        if (data == null) {
            throw new IllegalArgumentException("The input data array cannot be null.");
        }
        if (sortingStrategy == null) {
            setSortStrategyBasedOnSize(data.length);
        }
        return sortingStrategy.sort(data);
    }
}
