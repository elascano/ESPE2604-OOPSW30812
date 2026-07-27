/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.strategy.controller;

/**
 *
 * @author Daniel Codena, @CodeBreakers, ESPE
 */
public class SortingContext {

    private SortingStrategy sortingStrategy;

    public SortingStrategy sort(int size) {
        if (size < 2) {
            System.out.println("Enter at least 2 numbers");
        } else {
            if (size < 7) {
                this.setSortStrategy(new BubbleSort());
            } else {
                if (size < 11) {
                    this.setSortStrategy(new InsertionSort());
                } else {
                    this.setSortStrategy(new QuickSort());
                }
            }
        }
        return sortingStrategy;
    }

    private void setSortStrategy(SortingStrategy strategy) {
        this.sortingStrategy = strategy;
    }

    public SortingStrategy getSortingStrategy() {
        return sortingStrategy;
    }
    
    
}
