/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.strategy.model;

/**
 *
 * @author ronal
 */
public class BubbleSort implements SortingStrategy {

    @Override
    public int[] sort(int[] data) {

        int[] array = data.clone();

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {

                if (array[j] > array[j + 1]) {

                    int aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;

                }

            }
        }

        return array;

    }

}
