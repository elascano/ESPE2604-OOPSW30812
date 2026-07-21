/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.strategy;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class SortApp {
    public static void main(String args[]) {
        int data[] = {3, 6, 4, 6, 7, 8, 5, 6, 7, 5, 3, 3};
        SortingContext sc = new SortingContext();
        int sortedList[] = sc.sort(data);

        System.out.print("Sorted data: ");
        for (int num : sortedList) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}