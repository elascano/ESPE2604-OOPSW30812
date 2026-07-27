/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.strategy.controller;

import java.util.ArrayList;

/**
 *
 * @author Daniel Codena, @CodeBreakers, ESPE
 */
public class QuickSort extends SortingStrategy {

    @Override
    public ArrayList<Object> sort(ArrayList<Object> numbers) {
        System.out.println("Quick Sort");
        quickSort(numbers, 0, numbers.size() - 1);
        return numbers;
    }

    private void quickSort(ArrayList<Object> numbers, int low, int high) {
        if (low < high) {
            int pi = partition(numbers, low, high);

            quickSort(numbers, low, pi - 1);
            quickSort(numbers, pi + 1, high);
        }
    }

    private int partition(ArrayList<Object> numbers, int low, int high) {

        int pivot = (Integer) numbers.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if ((Integer) numbers.get(j) <= pivot) {
                i++;

                Object temp = numbers.get(i);
                numbers.set(i, numbers.get(j));
                numbers.set(j, temp);
            }
        }

        Object temp = numbers.get(i + 1);
        numbers.set(i + 1, numbers.get(high));
        numbers.set(high, temp);

        return i + 1;
    }

}