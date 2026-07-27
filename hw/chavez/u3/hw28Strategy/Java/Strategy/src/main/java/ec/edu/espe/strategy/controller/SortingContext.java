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
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class SortingContext {
    private SortingStrategy strategy;

    public int[] sort(int[] data) {

        if (data.length < 30) {
            strategy = new BubbleSort();
        } else if (data.length < 100) {
            strategy = new InsertionSort();
        } else {
            strategy = new QuickSort();
        }

        return strategy.sort(data);
    }
    
}
