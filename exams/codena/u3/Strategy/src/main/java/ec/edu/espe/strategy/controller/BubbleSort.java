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
public class BubbleSort extends SortingStrategy {

    @Override
    public ArrayList<Object> sort(ArrayList<Object> numbers) {
        System.out.println("Bubble Sort");
        System.out.println("Bubble Sort");

        int n = numbers.size();

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                int a = (Integer) numbers.get(j);
                int b = (Integer) numbers.get(j + 1);

                if (a > b) {
                    numbers.set(j, b);
                    numbers.set(j + 1, a);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        return numbers;

    }

}
