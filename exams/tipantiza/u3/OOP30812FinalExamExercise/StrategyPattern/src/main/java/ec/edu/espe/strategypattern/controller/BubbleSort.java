
package ec.edu.espe.strategypattern.controller;

import ec.edu.espe.strategypattern.model.SortingStrategy;

/**
 *
 * @author Alexander Tipantiza, CodeBreakers, @ESPE
 */

public class BubbleSort extends SortingStrategy {
    @Override
    public int[] sort(int[] numbers) {
        int[] array = numbers.clone();
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}