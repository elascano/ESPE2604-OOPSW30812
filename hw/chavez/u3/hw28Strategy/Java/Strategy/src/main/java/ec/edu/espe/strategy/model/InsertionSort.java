/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.strategy.model;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class InsertionSort implements SortingStrategy{

    @Override
    public int[] sort(int[] data) {
        for (int i = 1; i < data.length; i++) {

            int key = data[i];
            int j = i - 1;

            while (j >= 0 && data[j] > key) {

                data[j + 1] = data[j];
                j--;
            }

            data[j + 1] = key;
        }

        return data;
    }  
}
