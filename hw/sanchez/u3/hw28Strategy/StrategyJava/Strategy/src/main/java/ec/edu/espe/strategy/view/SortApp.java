/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.strategy.view;

import ec.edu.espe.strategy.controller.SortingContext;
import ec.edu.espe.strategy.model.BubbleSort;
import ec.edu.espe.strategy.model.InsertionSort;
import ec.edu.espe.strategy.model.QuickSort;
import ec.edu.espe.strategy.model.SortingStrategy;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class SortApp {

    public static void main(String[] args) {

        int[] data = {3, 6, 4, 6, 7, 8, 5, 6, 7, 5, 3, 3};

        SortingContext context = new SortingContext();

        System.out.println("Original array:");
        printArray(data);

        SortingStrategy strategy = context.setSortStrategy(data.length);

        System.out.println("\nStrategy selected: " + getStrategyName(strategy));

        int[] sortedData = context.sort(data);

        System.out.println("\nSorted array:");
        printArray(sortedData);

    }

    private static void printArray(int[] data) {

        for (int number : data) {
            System.out.print(number + " ");
        }

        System.out.println();

    }

    private static String getStrategyName(SortingStrategy strategy) {

        if (strategy instanceof BubbleSort) {
            return "Bubble Sort";
        }

        if (strategy instanceof InsertionSort) {
            return "Insertion Sort";
        }

        if (strategy instanceof QuickSort) {
            return "Quick Sort";
        }

        return "Unknown Strategy";

    }

}