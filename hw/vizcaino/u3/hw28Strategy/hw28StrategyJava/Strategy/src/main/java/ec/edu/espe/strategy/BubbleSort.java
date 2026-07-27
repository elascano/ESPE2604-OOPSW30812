/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.strategy;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class BubbleSort implements SortingStrategy {
    public int[] sort(int data[]) {
        System.out.println("Sorting using BubbleSort");
        int n = data.length;
        int[] arr = data.clone();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}