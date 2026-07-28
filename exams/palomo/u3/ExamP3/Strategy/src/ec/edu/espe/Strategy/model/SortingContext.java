/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.Strategy.model;

/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
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

        // Simplificación de rangos eliminando evaluaciones redundantes
        if (size <= 6) {
            this.sortingStrategy = new BubbleSort();
        } else if (size <= 10) {
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

        // Si no se asignó una estrategia manualmente, se selecciona por tamaño por defecto
        if (this.sortingStrategy == null) {
            setSortStrategyBasedOnSize(data.length);
        }

        return this.sortingStrategy.sort(data);
    }
}
