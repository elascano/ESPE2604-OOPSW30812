package ec.edu.espe.strategypattern.controller;

import ec.edu.espe.strategypattern.model.SortingStrategy;

/**
 *
 * @author Alexander Tipantiza, CodeBreakers, @ESPE
 */

public class SortingContext {
    private SortingStrategy sortStrategy;

    public SortingContext() {
        // Estrategia por defecto
        this.sortStrategy = new QuickSort();
    }

    public SortingContext(SortingStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public SortingStrategy getSortStrategy() {
        return sortStrategy;
    }

    public void setSortStrategy(SortingStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public int[] sort(int[] numbers) {
        if (sortStrategy == null) {
            throw new IllegalStateException("Strategy is not set.");
        }
        return sortStrategy.sort(numbers);
    }
}