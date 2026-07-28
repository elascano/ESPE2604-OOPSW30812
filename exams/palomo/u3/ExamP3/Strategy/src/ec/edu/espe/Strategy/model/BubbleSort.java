/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.Strategy.model;

/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class BubbleSort implements SortingStrategy{
    
    @Override
    public int[] sort(int[] data) {
        if (data == null) {
            return new int[0];
        }
        int[] sorted = data.clone();
        int n = sorted.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sorted[j] > sorted[j + 1]) {
                    int temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        return sorted;
    }
}
