/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.strategy.model;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class InsertionSort implements SortingStrategy {

    @Override
    public int[] sort(int[] data) {

        int[] array = data.clone();

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
