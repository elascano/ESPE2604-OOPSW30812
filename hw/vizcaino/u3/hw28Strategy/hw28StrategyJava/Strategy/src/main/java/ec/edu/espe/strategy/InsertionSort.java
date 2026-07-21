/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.strategy;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class InsertionSort implements SortingStrategy {
    public int[] sort(int data[]) {
        System.out.println("Sorting using InsertionSort");
        int n = data.length;
        int[] arr = data.clone();
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
}
