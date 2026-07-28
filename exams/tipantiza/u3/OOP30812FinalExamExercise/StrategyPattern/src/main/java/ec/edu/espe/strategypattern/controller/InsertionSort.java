
package ec.edu.espe.strategypattern.controller;

import ec.edu.espe.strategypattern.model.SortingStrategy;

/**
 *
 * @author Alexander Tipantiza, CodeBreakers, @ESPE
 */

public class InsertionSort extends SortingStrategy {
    @Override
    public int[] sort(int[] numbers) {
        int[] array = numbers.clone();
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        return array;
    }
}