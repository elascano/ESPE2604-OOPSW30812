/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.strategy.controller;

import ec.edu.espe.strategy.model.BubbleSort;
import ec.edu.espe.strategy.model.InsertionSort;
import ec.edu.espe.strategy.model.QuickSort;
import ec.edu.espe.strategy.model.SortingStrategy;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class SortingContext {

    private SortingStrategy sortingStrategy;

    public int[] sort(int[] data) {
        sortingStrategy = setSortStrategy(data.length);
        return sortingStrategy.sort(data);
    }

    public SortingStrategy setSortStrategy(int size) {

        if (size > 0 && size < 30) {
            sortingStrategy = new BubbleSort();
        } else if (size >= 30 && size < 100) {
            sortingStrategy = new InsertionSort();
        } else {
            sortingStrategy = new QuickSort();
        }

        return sortingStrategy;
    }

}
