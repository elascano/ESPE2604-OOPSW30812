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
public class InsertionSort extends SortingStrategy{

    @Override
    public ArrayList<Object> sort(ArrayList<Object> numbers) {
        System.out.println("Insertion Sort");

        for (int i = 1; i < numbers.size(); i++) {

            int key = (Integer) numbers.get(i);
            int j = i - 1;

            while (j >= 0 && (Integer) numbers.get(j) > key) {
                numbers.set(j + 1, numbers.get(j));
                j--;
            }

            numbers.set(j + 1, key);
        }

        return numbers;
    }
    
}
