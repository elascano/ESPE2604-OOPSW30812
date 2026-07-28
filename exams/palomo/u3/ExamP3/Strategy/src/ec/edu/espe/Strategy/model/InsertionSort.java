/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.Strategy.model;

/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class InsertionSort implements SortingStrategy{
    
    @Override
    public int[] sort(int[] data) {
        if (data == null) {
            return new int[0];
        }
        int[] sorted = data.clone();
        int n = sorted.length;
        for (int i = 1; i < n; i++) {
            int key = sorted[i];
            int j = i - 1;
            while (j >= 0 && sorted[j] > key) {
                sorted[j + 1] = sorted[j];
                j = j - 1;
            }
            sorted[j + 1] = key;
        }
        return sorted;
    }
}
